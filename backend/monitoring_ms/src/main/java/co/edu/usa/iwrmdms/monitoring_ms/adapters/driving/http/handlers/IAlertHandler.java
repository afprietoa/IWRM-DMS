package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.AlertCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.AlertUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertResponseDto;
import org.springframework.data.domain.Page;


import java.util.List;

public interface IAlertHandler {
    void createAlert(AlertCreateRequestDto alertCreateRequestDto);
    void updateAlert(AlertUpdateRequestDto alertUpdateRequestDto);
    Page<AlertPaginationResponseDto> getPaginationAlert(Integer pageSize, String sortBy);
    List<AlertListResponseDto> getListAlert();
    AlertResponseDto getAlert(Integer idAlert);
    void deleteAlert(Integer idAlert);
}
