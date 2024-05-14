package co.edu.usa.iwrmdms.user_ms.adapters.driving.dto.request;

import co.edu.usa.iwrmdms.user_ms.domains.model.enums.AcademicDegree;
import co.edu.usa.iwrmdms.user_ms.domains.model.enums.DniType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProfileRequestDto {
    private DniType dniType;
    private String dniNumber;
    private String firstName;
    private String lastName;
    private String genre;
    private String email;
    private String phone;
    private String address;
    private AcademicDegree academicDegree;
    private String occupation;
}
