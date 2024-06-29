package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.adapter;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity.ResourceEntity;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.exceptions.NoDataFoundException;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.exceptions.ResourceNotFoundException;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.mappers.IResourceEntityMapper;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.repositories.IResourceRepository;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourceListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourcePaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourceResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Resource;
import co.edu.usa.iwrmdms.monitoring_ms.domains.spi.IResourcePersistencePort;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class ResourcePostgresqlAdapter implements IResourcePersistencePort {
    private final IResourceRepository resourceRepository;
    private final IResourceEntityMapper resourceEntityMapper;


    @Override
    public void saveResource(Resource resource) {
        resourceRepository.save(resourceEntityMapper.toResourceEntity(resource));
    }

    @Override
    public Page<ResourcePaginationResponseDto> getPaginationResource(Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(0,pageSize, Sort.by(sortBy).ascending());
        Page<ResourceEntity> resourceEntityPage = resourceRepository.findAll(pageable);
        return resourceEntityPage.map(resourceEntityMapper::toResourcePaginationResponseDto);
    }

    @Override
    public List<ResourceListResponseDto> getListResource() {
        List<ResourceEntity> resourceEntityList = resourceRepository.findAll();
        if (resourceEntityList.isEmpty()) throw new NoDataFoundException();
        return resourceEntityList.stream().map(resourceEntityMapper::toResourceListResponseDto).toList();
    }

    @Override
    public ResourceResponseDto getResourceById(Integer idResource) {
         ResourceEntity resourceEntity = resourceRepository.findById(idResource).orElseThrow(ResourceNotFoundException::new);
        return resourceEntityMapper.toResourceResponseDto(resourceEntity);
    }

    @Override
    public void deleteResource(Integer idResource) {
        resourceRepository.deleteById(idResource);
    }
}
