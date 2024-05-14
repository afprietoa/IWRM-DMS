package co.edu.usa.iwrmdms.monitoring_ms.domains.api;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.ResourceCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.ResourceUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourceListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourcePaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourceResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Resource;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IResourceServicePort {
    void createResource(Resource resource);
    void updateResource(Integer idResource, Resource resource);
    Page<ResourcePaginationResponseDto> getPaginationResource(Integer pageSize, String sortBy);
    List<ResourceListResponseDto> getListResource();
    ResourceResponseDto getResource(Integer idResource);
    void deleteResource(Integer idResource);
}
