package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Address;
import uz.jurayev.academy.repository.AddressRepository;
import uz.jurayev.academy.rest.request.AddressRequest;
import uz.jurayev.academy.service.AddressService;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public Address createAddress(AddressRequest addressDto) {

        Address address = new Address();
        address.setCountry(addressDto.getCountry());
        address.setRegion(addressDto.getRegion());
        address.setDistrict(addressDto.getDistrict());
        address.setDescription(addressDto.getDescription());
        addressRepository.save(address);

        return address;
    }
}
