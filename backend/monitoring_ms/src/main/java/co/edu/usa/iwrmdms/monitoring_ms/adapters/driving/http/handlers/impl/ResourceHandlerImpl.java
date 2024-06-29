package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers.impl;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.ResourceCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.ResourceUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourceListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourcePaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourceResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers.IResourceHandler;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper.IResourceRequestMapper;
import co.edu.usa.iwrmdms.monitoring_ms.domains.api.IResourceServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceHandlerImpl implements IResourceHandler {

    private final IResourceServicePort resourceServicePort;

    private final IResourceRequestMapper resourceRequestMapper;
    @Override
    public void createResource(ResourceCreateRequestDto resourceCreateRequestDto) {
        resourceServicePort.createResource(resourceRequestMapper.toCreateResource(resourceCreateRequestDto));
    }

    @Override
    public void updateResource(ResourceUpdateRequestDto resourceUpdateRequestDto) {
        resourceServicePort.updateResource(resourceRequestMapper.toUpdateResource(resourceUpdateRequestDto));
    }

    @Override
    public Page<ResourcePaginationResponseDto> getPaginationResource(Integer pageSize, String sortBy) {
        return resourceServicePort.getPaginationResource(pageSize, sortBy);
    }

    @Override
    public List<ResourceListResponseDto> getListResource() {

        return resourceServicePort.getListResource();
    }

    @Override
    public ResourceResponseDto getResource(Integer idResource) {

        return resourceServicePort.getResource(idResource);
    }

    @Override
    public void deleteResource(Integer idResource) {
        resourceServicePort.deleteResource(idResource);
    }
}
