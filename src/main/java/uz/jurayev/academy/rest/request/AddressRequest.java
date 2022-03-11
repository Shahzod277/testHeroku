package uz.jurayev.academy.rest.request;

import lombok.*;

@Value
@Builder
public class AddressRequest {

    Integer id;
    String country;
    String region;
    String district;
    String description;
}
