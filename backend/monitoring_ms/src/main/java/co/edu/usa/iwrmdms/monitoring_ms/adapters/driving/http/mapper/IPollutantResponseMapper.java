package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.ResourceResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Pollutant;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPollutantResponseMapper {
    Pollutant toPollutant(PollutantResponseDto pollutantResponseDto);
}
