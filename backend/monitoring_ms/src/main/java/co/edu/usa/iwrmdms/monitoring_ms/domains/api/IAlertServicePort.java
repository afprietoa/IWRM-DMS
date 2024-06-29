package co.edu.usa.iwrmdms.monitoring_ms.domains.api;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Alert;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IAlertServicePort {
    void createAlert(Alert alert);
    void updateAlert(Alert alert);
    Page<AlertPaginationResponseDto> getPaginationAlert(Integer pageSize, String sortBy);
    List<AlertListResponseDto> getListAlert();
    AlertResponseDto getAlert(Integer idAlert);
    void deleteAlert(Integer idAlert);
}
