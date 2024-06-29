package co.edu.usa.iwrmdms.monitoring_ms.domains.api;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Measurement;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IMeasurementServicePort {
    void createMeasurement(Measurement measurement);
    void updateMeasurement(Measurement measurement);
    Page<MeasurementPaginationResponseDto> getPaginationMeasurement(Integer pageSize, String sortBy);
    List<MeasurementListResponseDto> getListMeasurement();
    MeasurementResponseDto getMeasurement(Integer idMeasurement);
    void deleteMeasurement(Integer idMeasurement);
}
