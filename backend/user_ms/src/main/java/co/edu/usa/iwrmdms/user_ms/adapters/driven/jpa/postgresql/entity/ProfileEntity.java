package co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.entity;

import co.edu.usa.iwrmdms.user_ms.domains.model.enums.AcademicDegree;
import co.edu.usa.iwrmdms.user_ms.domains.model.enums.DniType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="profiles")
@Data
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;
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
