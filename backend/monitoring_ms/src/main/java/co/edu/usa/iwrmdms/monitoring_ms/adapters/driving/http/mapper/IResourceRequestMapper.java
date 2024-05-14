package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.ResourceCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.ResourceUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IResourceRequestMapper {
    Resource toCreateResource(ResourceCreateRequestDto resourceCreateRequestDto);
    Resource toUpdateResource(ResourceUpdateRequestDto resourceUpdateRequestDto);
}


