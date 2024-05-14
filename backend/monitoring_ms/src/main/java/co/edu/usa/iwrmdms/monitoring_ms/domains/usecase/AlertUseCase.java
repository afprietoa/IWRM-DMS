package co.edu.usa.iwrmdms.monitoring_ms.domains.usecase;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.api.IAlertServicePort;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Alert;
import co.edu.usa.iwrmdms.monitoring_ms.domains.spi.IAlertPersistencePort;
import org.springframework.data.domain.Page;

import java.util.List;

public class AlertUseCase implements IAlertServicePort {
    private final IAlertPersistencePort alertPersistencePort;

    public AlertUseCase(IAlertPersistencePort alertPersistencePort) {
        this.alertPersistencePort = alertPersistencePort;
    }

    @Override
    public void createAlert(Alert alert) {
        alertPersistencePort.saveAlert(alert);
    }

    @Override
    public void updateAlert(Integer idAlert, Alert alert) {
        Alert tempAlert = alertPersistencePort.getAlertById(idAlert).get();
        tempAlert.setDate(alert.getDate());
        tempAlert.setLevel(alert.getLevel());
        tempAlert.setMessage(alert.getMessage());
        tempAlert.setUserId(alert.getUserId());
        tempAlert.setEventId(alert.getEventId());
        alertPersistencePort.saveAlert(tempAlert);
    }

    @Override
    public Page<AlertPaginationResponseDto> getPaginationAlert(Integer pageSize, String sortBy) {
        return alertPersistencePort.getPaginationAlert(pageSize, sortBy);
    }

    @Override
    public List<AlertListResponseDto> getListAlert() {
        return alertPersistencePort.getListAlert();
    }

    @Override
    public AlertResponseDto getAlert(Integer idAlert) {
        return alertPersistencePort.getAlertById(idAlert).getLeft();
    }

    @Override
    public void deleteAlert(Integer idAlert) {
        alertPersistencePort.deleteAlert(idAlert);
    }
}
