package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers.impl;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.AlertCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.AlertUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers.IAlertHandler;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper.IAlertRequestMapper;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper.IEventRequestMapper;
import co.edu.usa.iwrmdms.monitoring_ms.domains.api.IAlertServicePort;
import co.edu.usa.iwrmdms.monitoring_ms.domains.api.IEventServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertHandlerImpl implements IAlertHandler {
    private final IAlertServicePort alertServicePort;

    private final IAlertRequestMapper alertRequestMapper;
    @Override
    public void createAlert(AlertCreateRequestDto alertCreateRequestDto) {
        alertServicePort.createAlert(alertRequestMapper.toCreateAlert(alertCreateRequestDto));
    }

    @Override
    public void updateAlert(Integer idAlert, AlertUpdateRequestDto alertUpdateRequestDto) {
        alertServicePort.updateAlert(idAlert, alertRequestMapper.toUpdateAlert(alertUpdateRequestDto));
    }

    @Override
    public Page<AlertPaginationResponseDto> getPaginationAlert(Integer pageSize, String sortBy) {
        return alertServicePort.getPaginationAlert(pageSize, sortBy);
    }

    @Override
    public List<AlertListResponseDto> getListAlert() {
        return alertServicePort.getListAlert();
    }

    @Override
    public AlertResponseDto getAlert(Integer idAlert) {
        return alertServicePort.getAlert(idAlert);
    }

    @Override
    public void deleteAlert(Integer idAlert) {
        alertServicePort.deleteAlert(idAlert);
    }
}
