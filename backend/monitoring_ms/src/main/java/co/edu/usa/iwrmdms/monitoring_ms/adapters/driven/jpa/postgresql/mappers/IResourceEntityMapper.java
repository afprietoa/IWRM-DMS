package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.mappers;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity.ResourceEntity;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourceListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourcePaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourceResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IResourceEntityMapper {
    ResourceEntity toResourceEntity(Resource resource);
    Resource toResource(ResourceEntity resourceEntity);
    ResourceResponseDto toResourceResponseDto(ResourceEntity resourceEntity);
    ResourcePaginationResponseDto toResourcePaginationResponseDto(ResourceEntity resourceEntity);
    ResourceListResponseDto toResourceListResponseDto(ResourceEntity resourceEntity);
}
