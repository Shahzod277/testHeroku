package uz.jurayev.academy.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.jurayev.academy.domain.Student;
import uz.jurayev.academy.domain.StudentGroup;
import uz.jurayev.academy.domain.Tutor;
import uz.jurayev.academy.domain.User;
import uz.jurayev.academy.rest.GroupDto;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<StudentGroup, Integer> {

    Optional<StudentGroup> findByGroupName(String groupName);

        @Query(value = "select * from student_group as sg inner join tutor t on t.id = sg.tutor_id " +
              " inner join users u on t.user_id = u.id where u.email=:email", nativeQuery = true)
        List<StudentGroup> getAllGroupsByUsername(@Param("email") String email);
}
