package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.PollutantCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.PollutantUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Pollutant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPollutantRequestMapper {
    Pollutant toCreatePollutant(PollutantCreateRequestDto pollutantCreateRequestDto);
    Pollutant toUpdatePollutant(PollutantUpdateRequestDto pollutantUpdateRequestDto);
}
