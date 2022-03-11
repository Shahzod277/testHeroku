package uz.jurayev.academy.rest.request;

import lombok.*;

import java.util.List;

@Value
@Builder
public class AdminTutorRequest {

    Long id;
    AddressRequest addressRequest;
    String category;
    String level;
    String description;
    List<String> groupRequest;
    UserRequest userRequest;
}
