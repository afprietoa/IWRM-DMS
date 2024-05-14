package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.MeasurementCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.MeasurementUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementResponseDto;
import org.springframework.data.domain.Page;


import java.util.List;

public interface IMeasurementHandler {
    void createMeasurement(MeasurementCreateRequestDto measurementCreateRequestDto);
    void updateMeasurement(Integer idMeasurement, MeasurementUpdateRequestDto measurementUpdateRequestDto);
    Page<MeasurementPaginationResponseDto> getPaginationMeasurement(Integer pageSize, String sortBy);
    List<MeasurementListResponseDto> getListMeasurement();
    MeasurementResponseDto getMeasurement(Integer idMeasurement);
    void deleteMeasurement(Integer idMeasurement);
}
