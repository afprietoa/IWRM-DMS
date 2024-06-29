package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Alert;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IAlertResponseMapper {
    Alert toAlert(AlertResponseDto alertResponseDto);
}
