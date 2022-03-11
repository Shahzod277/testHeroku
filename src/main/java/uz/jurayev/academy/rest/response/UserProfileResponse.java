package uz.jurayev.academy.rest.response;

import lombok.Builder;
import lombok.Value;
import java.time.LocalDate;

@Value
@Builder
public class UserProfileResponse {

    String firstname;
    String fatherName;
    String lastname;
    LocalDate birthDate;
    String phoneNumber;
    String gender;
}
