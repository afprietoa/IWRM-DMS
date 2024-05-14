package co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.adapter;

import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.entity.RoleEntity;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.exceptions.NoDataFoundException;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.mappers.IRoleEntityMapper;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.repositories.IRoleRepository;
import co.edu.usa.iwrmdms.user_ms.domains.model.Role;
import co.edu.usa.iwrmdms.user_ms.domains.spi.IRolePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
public class RolePostgresqlAdapter implements IRolePersistencePort {
    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;

    @Override
    public List<Role> getAllRoles() {
        List<RoleEntity> roleEntityList = roleRepository.findAll();
        if(roleEntityList.isEmpty()) throw new NoDataFoundException();
        return roleEntityMapper.toRoleList(roleEntityList);
    }
}
