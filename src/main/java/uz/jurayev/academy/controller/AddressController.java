package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.jurayev.academy.domain.Address;
import uz.jurayev.academy.rest.request.AddressRequest;
import uz.jurayev.academy.service.impl.AddressServiceImpl;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressServiceImpl addressServiceIpml;

    @PostMapping
    public Address createAddress(@RequestBody AddressRequest addressDto) {
        return addressServiceIpml.createAddress(addressDto);
    }
}
