package co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.entity;

import co.edu.usa.iwrmdms.user_ms.domains.model.Profile;
import co.edu.usa.iwrmdms.user_ms.domains.model.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "id_profile")
    private ProfileEntity profile;
    @ManyToOne
    @JoinColumn(name = "id_role")
    private RoleEntity role;

}
