package co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.repositories;

import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByProfileEntityIdAndRoleEntityId(Long profileId, Long roleId);
    void deleteByProfileEntityIdAndRoleEntityId(Long profileId, Long roleId);
    List<UserEntity> findAllByRoleEntityId(Long idRole, Pageable pageable);
    Optional<UserEntity> findByProfileEntityId(Long profileId);
}