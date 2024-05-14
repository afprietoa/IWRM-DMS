package co.edu.usa.iwrmdms.monitoring_ms.domains.usecase;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.api.IMeasurementServicePort;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Measurement;
import co.edu.usa.iwrmdms.monitoring_ms.domains.spi.IMeasurementPersistencePort;
import org.springframework.data.domain.Page;

import java.util.List;

public class MeasurementUseCase implements IMeasurementServicePort {
    private final IMeasurementPersistencePort measurementPersistencePort;

    public MeasurementUseCase(IMeasurementPersistencePort measurementPersistencePort) {
        this.measurementPersistencePort = measurementPersistencePort;
    }

    @Override
    public void createMeasurement(Measurement measurement) {
        measurementPersistencePort.saveMeasurement(measurement);
    }

    @Override
    public void updateMeasurement(Integer idMeasurement, Measurement measurement) {
        Measurement tempMeasurement = measurementPersistencePort.getMeasurementById(idMeasurement).get();
        tempMeasurement.setDate(measurement.getDate());
        tempMeasurement.setPh(measurement.getPh());
        tempMeasurement.setTemperature(measurement.getTemperature());
        tempMeasurement.setUserId(measurement.getUserId());
        tempMeasurement.setPollutantId(measurement.getPollutantId());
        tempMeasurement.setResourceId(measurement.getResourceId());
        measurementPersistencePort.saveMeasurement(tempMeasurement);
    }

    @Override
    public Page<MeasurementPaginationResponseDto> getPaginationMeasurement(Integer pageSize, String sortBy) {
        return measurementPersistencePort.getPaginationMeasurement(pageSize, sortBy);
    }

    @Override
    public List<MeasurementListResponseDto> getListMeasurement() {
        return measurementPersistencePort.getListMeasurement();
    }

    @Override
    public MeasurementResponseDto getMeasurement(Integer idMeasurement) {
        return measurementPersistencePort.getMeasurementById(idMeasurement).getLeft();
    }

    @Override
    public void deleteMeasurement(Integer idMeasurement) {
        measurementPersistencePort.deleteMeasurement(idMeasurement);
    }
}
