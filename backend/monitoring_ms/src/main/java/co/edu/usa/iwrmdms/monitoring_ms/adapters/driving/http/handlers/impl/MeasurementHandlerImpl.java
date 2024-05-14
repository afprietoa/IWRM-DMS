package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers.impl;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.MeasurementCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.MeasurementUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers.IMeasurementHandler;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper.IMeasurementRequestMapper;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper.IPollutantRequestMapper;
import co.edu.usa.iwrmdms.monitoring_ms.domains.api.IMeasurementServicePort;
import co.edu.usa.iwrmdms.monitoring_ms.domains.api.IPollutantServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasurementHandlerImpl implements IMeasurementHandler {
    private final IMeasurementServicePort measurementServicePort;

    private final IMeasurementRequestMapper measurementRequestMapper;
    @Override
    public void createMeasurement(MeasurementCreateRequestDto measurementCreateRequestDto) {
        measurementServicePort.createMeasurement(measurementRequestMapper.toCreateMeasurement(measurementCreateRequestDto));
    }

    @Override
    public void updateMeasurement(Integer idMeasurement, MeasurementUpdateRequestDto measurementUpdateRequestDto) {
        measurementServicePort.updateMeasurement(idMeasurement, measurementRequestMapper.toUpdateMeasurement(measurementUpdateRequestDto));
    }

    @Override
    public Page<MeasurementPaginationResponseDto> getPaginationMeasurement(Integer pageSize, String sortBy) {
        return measurementServicePort.getPaginationMeasurement(pageSize, sortBy);
    }

    @Override
    public List<MeasurementListResponseDto> getListMeasurement() {
        return measurementServicePort.getListMeasurement();
    }

    @Override
    public MeasurementResponseDto getMeasurement(Integer idMeasurement) {
        return measurementServicePort.getMeasurement(idMeasurement);
    }

    @Override
    public void deleteMeasurement(Integer idMeasurement) {
        measurementServicePort.deleteMeasurement(idMeasurement);
    }
}
