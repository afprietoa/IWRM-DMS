package co.edu.usa.iwrmdms.monitoring_ms.domains.spi;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourceListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourcePaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourceResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Resource;
import io.vavr.control.Either;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IResourcePersistencePort {
    void saveResource(Resource resource);
    Page<ResourcePaginationResponseDto> getPaginationResource(Integer pageSize, String sortBy);
    List<ResourceListResponseDto> getListResource();
    Either<ResourceResponseDto, Resource> getResourceById(Integer idResource);
    void deleteResource(Integer idResource);
}
