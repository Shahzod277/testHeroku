package uz.jurayev.academy.rest.request;

import lombok.*;
import java.time.LocalDate;

@Value
public class UserProfileRequest {

    String firstname;
    String fatherName;
    String lastname;
    LocalDate birthDate;
    String phoneNumber;
    String gender;
    String passportData;
}
