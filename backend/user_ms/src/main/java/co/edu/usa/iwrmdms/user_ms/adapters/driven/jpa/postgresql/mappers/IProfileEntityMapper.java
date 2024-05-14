package co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.mappers;

import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.entity.ProfileEntity;
import co.edu.usa.iwrmdms.user_ms.domains.model.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IProfileEntityMapper {
    ProfileEntity toEntity(Profile profile);
    Profile toProfile(ProfileEntity profileEntity);
}
