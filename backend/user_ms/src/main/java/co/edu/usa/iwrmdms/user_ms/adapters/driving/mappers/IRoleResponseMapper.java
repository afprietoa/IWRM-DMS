package co.edu.usa.iwrmdms.user_ms.adapters.driving.mappers;

import co.edu.usa.iwrmdms.user_ms.adapters.driving.dto.response.RoleResponseDto;
import co.edu.usa.iwrmdms.user_ms.domains.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleResponseMapper {
    List<RoleResponseDto> toResponseList(List<Role> roleList);
}
