package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.AlertCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.AlertUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Alert;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IAlertRequestMapper {
    Alert toCreateAlert(AlertCreateRequestDto alertCreateRequestDto);
    Alert toUpdateAlert(AlertUpdateRequestDto alertUpdateRequestDto);
}
