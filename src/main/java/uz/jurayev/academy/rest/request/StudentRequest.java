package uz.jurayev.academy.rest.request;

import lombok.Data;
import uz.jurayev.academy.rest.CreativePotential;
import uz.jurayev.academy.rest.FamilyInformationDto;
import uz.jurayev.academy.rest.GroupDto;
import uz.jurayev.academy.rest.StudyInfoDto;
import java.time.LocalDate;
import java.util.List;

@Data
public class StudentRequest {

    private String firstname;
    private String lastname;
    private String fatherName;
    private String nationality;
    private String passportData;
    private GroupDto group;
    private String gender;
    private AddressRequest addressRequest;
    private LocalDate birthDate;
    private FamilyInformationDto familyInformation;
    private StudyInfoDto studyInfo;
    private Boolean familyStatus;
    private List<CreativePotential> creativePotential;
}
