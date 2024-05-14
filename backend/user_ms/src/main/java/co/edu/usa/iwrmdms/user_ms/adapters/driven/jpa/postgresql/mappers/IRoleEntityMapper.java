package co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.mappers;

import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.entity.RoleEntity;
import co.edu.usa.iwrmdms.user_ms.domains.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleEntityMapper {
    List<Role> toRoleList(List<RoleEntity> roleEntityList);
}
