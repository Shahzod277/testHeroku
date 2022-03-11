package uz.jurayev.academy.domain;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Embeddable
public class UserProfile {

    @Column(length = 30)
    private String firstname;

    @Column(length = 30)
    private String lastname;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "phone_number", length = 15, unique = true,updatable = false)
    private String phoneNumber;

    private String gender;

    @Column(name = "passport_data", length = 10)
    private String passportData;

}
