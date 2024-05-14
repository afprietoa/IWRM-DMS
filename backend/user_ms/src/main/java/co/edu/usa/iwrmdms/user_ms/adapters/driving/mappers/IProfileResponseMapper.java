package co.edu.usa.iwrmdms.user_ms.adapters.driving.mappers;

import co.edu.usa.iwrmdms.user_ms.adapters.driving.dto.response.ProfileResponseDto;
import co.edu.usa.iwrmdms.user_ms.domains.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IProfileResponseMapper {
    @Mapping(source = "profile.fistName", target = "fistName")
    @Mapping(source = "profile.lastName", target = "lastName")
    @Mapping(source = "profile.email", target = "email")
    @Mapping(source = "profile.phone", target = "phone")
    @Mapping(source = "profile.address", target = "address")
    ProfileResponseDto userToProfileResponse(User user);
    List<ProfileResponseDto> userListToProfileResponseList(List<User> userList);
}
