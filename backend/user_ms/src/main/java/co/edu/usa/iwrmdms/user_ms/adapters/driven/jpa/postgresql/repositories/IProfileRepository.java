package co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.repositories;

import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProfileRepository extends JpaRepository<ProfileEntity, Long> {

    Optional<ProfileEntity> findByDniNumber(String dniNumber);

    Boolean existsByDniNumber(String dniNumber);

    boolean existsByEMail(String email);
}
