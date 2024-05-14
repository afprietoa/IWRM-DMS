package co.edu.usa.iwrmdms.user_ms.adapters.driving.mappers;

import co.edu.usa.iwrmdms.user_ms.adapters.driving.dto.request.UserRequestDto;
import co.edu.usa.iwrmdms.user_ms.domains.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {
    @Mapping(target = "profile.id", source = "idProfile")
    @Mapping(target = "role.id", source = "idRole")
    User toUser(UserRequestDto userRequestDto);
}
