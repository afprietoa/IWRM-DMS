package co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.mappers;

import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.entity.UserEntity;
import co.edu.usa.iwrmdms.user_ms.domains.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {
    @Mapping(target = "profileEntity.id", source = "profile.profileId")
    @Mapping(target = "roleEntity.id", source = "role.roleId")
    UserEntity toEntity(User user);
    @Mapping(target = "profile.profileId", source = "personEntity.id")
    @Mapping(target = "role.roleId", source = "roleEntity.id")
    User toUser(UserEntity userEntity);
    List<User> toUserList(List<UserEntity> userEntityList);
}
