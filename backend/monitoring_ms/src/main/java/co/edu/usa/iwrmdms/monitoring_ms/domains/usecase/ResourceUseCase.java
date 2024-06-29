package co.edu.usa.iwrmdms.monitoring_ms.domains.usecase;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourceListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourcePaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourceResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper.IResourceRequestMapper;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper.IResourceResponseMapper;
import co.edu.usa.iwrmdms.monitoring_ms.domains.api.IResourceServicePort;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Resource;
import co.edu.usa.iwrmdms.monitoring_ms.domains.spi.IResourcePersistencePort;
import org.springframework.data.domain.Page;

import java.util.List;

public class ResourceUseCase implements IResourceServicePort {
    private final IResourcePersistencePort resourcePersistencePort;
    private final IResourceResponseMapper resourceResponseMapper;
    public ResourceUseCase(IResourcePersistencePort resourcePersistencePort, IResourceResponseMapper resourceResponseMapper) {
        this.resourcePersistencePort = resourcePersistencePort;
        this.resourceResponseMapper = resourceResponseMapper;
    }

    @Override
    public void createResource(Resource resource) {
        resourcePersistencePort.saveResource(resource);
    }

    @Override
    public void updateResource(Resource resource) {
        Resource tempResource = resourceResponseMapper.toResource(this.getResource(resource.getResourceId()));
        tempResource.setName(resource.getName());
        tempResource.setType(resource.getType());
        tempResource.setLatitude(resource.getLatitude());
        tempResource.setLongitude(resource.getLongitude());
        tempResource.setLocation(resource.getLocation());
        resourcePersistencePort.saveResource(tempResource);
    }

    @Override
    public Page<ResourcePaginationResponseDto> getPaginationResource(Integer pageSize, String sortBy) {
        return resourcePersistencePort.getPaginationResource(pageSize, sortBy);
    }

    @Override
    public List<ResourceListResponseDto> getListResource() {
        return resourcePersistencePort.getListResource();
    }

    @Override
    public ResourceResponseDto getResource(Integer idResource) {
        return resourcePersistencePort.getResourceById(idResource);
    }

    @Override
    public void deleteResource(Integer idResource) {
        resourcePersistencePort.deleteResource(idResource);
    }
}
