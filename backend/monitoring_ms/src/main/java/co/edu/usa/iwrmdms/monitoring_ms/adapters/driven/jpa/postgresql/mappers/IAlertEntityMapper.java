package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.mappers;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity.AlertEntity;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Alert;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IAlertEntityMapper{
    AlertEntity toAlertEntity(Alert alert);
    Alert toAlert(AlertEntity alertEntity);
    AlertResponseDto toAlertResponseDto(AlertEntity alertEntity);
    AlertPaginationResponseDto toAlertPaginationResponseDto(AlertEntity alertEntity);
    AlertListResponseDto toAlertListResponseDto(AlertEntity alertEntity);
}
