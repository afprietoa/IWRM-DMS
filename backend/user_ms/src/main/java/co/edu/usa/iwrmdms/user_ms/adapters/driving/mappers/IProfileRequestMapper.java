package co.edu.usa.iwrmdms.user_ms.adapters.driving.mappers;

import co.edu.usa.iwrmdms.user_ms.adapters.driving.dto.request.ProfileRequestDto;
import co.edu.usa.iwrmdms.user_ms.domains.model.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IProfileRequestMapper {
    Profile toProfile(ProfileRequestDto profileRequestDto);
}
