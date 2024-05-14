package co.edu.usa.iwrmdms.user_ms.adapters.driving.dto.response;

import co.edu.usa.iwrmdms.user_ms.domains.model.enums.AcademicDegree;
import co.edu.usa.iwrmdms.user_ms.domains.model.enums.DniType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProfileResponseDto {
    private String firstName;
    private String lastName;
    private String genre;
    private String email;
    private String phone;
    private String address;
    private String occupation;
}
