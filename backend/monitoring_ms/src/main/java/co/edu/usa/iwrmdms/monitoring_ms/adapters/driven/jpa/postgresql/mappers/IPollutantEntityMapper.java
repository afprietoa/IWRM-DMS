package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.mappers;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity.PollutantEntity;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Pollutant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPollutantEntityMapper {
    PollutantEntity toPollutantEntity(Pollutant pollutant);
    Pollutant toPollutant(PollutantEntity pollutantEntity);
    PollutantResponseDto toPollutantResponseDto(PollutantEntity pollutantEntity);
    PollutantPaginationResponseDto toPollutantPaginationResponseDto(PollutantEntity pollutantEntity);
    PollutantListResponseDto toPollutantListResponseDto(PollutantEntity pollutantEntity);
}
