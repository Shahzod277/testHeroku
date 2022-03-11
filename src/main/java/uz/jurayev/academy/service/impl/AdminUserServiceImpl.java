package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.jurayev.academy.domain.Role;
import uz.jurayev.academy.domain.User;
import uz.jurayev.academy.domain.UserProfile;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.RoleRepository;
import uz.jurayev.academy.repository.UserRepository;
import uz.jurayev.academy.rest.request.UserRequest;
import uz.jurayev.academy.rest.response.UserResponse;
import uz.jurayev.academy.service.UserService;
import uz.jurayev.academy.util.responsemapper.UserResponseMapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminUserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserResponseMapper userResponseMapper;

    @Override
    @Transactional
    public UserResponse create(UserRequest requestDto) {

        User user = new User();
        dtoToEntity(requestDto, user);
        userRepository.save(user);
        return userResponseMapper.mapFrom(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponseDtos = new ArrayList<>();
        users.forEach(u -> {
            UserResponse userResponseDto = userResponseMapper.mapFrom(u);
            userResponseDtos.add(userResponseDto);
        });
        return userResponseDtos;
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getById(Long id) {
        User user = Optional.of(userRepository.findById(id)).get()
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));
        return userResponseMapper.mapFrom(user);
    }

    @Override
    @Transactional
    public Result edit(Long id, UserRequest requestDto) {

        User user = userRepository.findById(id).orElse(new User());
        user.getRoles().clear();
        user.setModifiedDate(LocalDateTime.now());
        dtoToEntity(requestDto, user);
        userRepository.save(user);
        return new Result("User successfully updated", true);
    }

    @Override
    @Transactional
    public Result delete(Long id) {

        Optional<User> userById = userRepository.findById(id);
        if (userById.isPresent()) {
            userById.get().removeRoles();
            userRepository.deleteById(userById.get().getId());
            return new Result("User successfully deleted", true);
        }
        return new Result("User not found", false);
    }

    private void dtoToEntity(UserRequest requestDto, User user) {
        user.setUsername(requestDto.getUsername());
        user.setEmail(requestDto.getEmail());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        user.setUserProfile(UserProfile.builder()
                .firstname(requestDto.getProfile().getFirstname())
                .lastname(requestDto.getProfile().getLastname())
                .birthDate(requestDto.getProfile().getBirthDate())
                .phoneNumber(requestDto.getProfile().getPhoneNumber())
                .passportData(requestDto.getProfile().getPassportData())
                .gender(requestDto.getProfile().getGender())
                .build()
        );

        requestDto.getRoles().forEach(roleName -> {
            Role role;
            Optional<Role> roleById = roleRepository.findByRoleName("ROLE_" + roleName.toUpperCase());
            if (roleById.isPresent()) {
                role = roleById.get();
                role.setRoleName("ROLE_" + roleName.toUpperCase());
                user.addRole(role);
            } else {
                role = new Role();
                role.setRoleName("ROLE_" + roleName.toUpperCase());
                role.setUsers(new ArrayList<>());
                user.addRole(role);
            }
//            roleRepository.save(role);
        });
    }
}
