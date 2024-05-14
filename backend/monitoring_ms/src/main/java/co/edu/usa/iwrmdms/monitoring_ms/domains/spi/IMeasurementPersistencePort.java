package co.edu.usa.iwrmdms.monitoring_ms.domains.spi;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Measurement;
import io.vavr.control.Either;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IMeasurementPersistencePort {
    void saveMeasurement(Measurement measurement);
    Page<MeasurementPaginationResponseDto> getPaginationMeasurement(Integer pageSize, String sortBy);
    List<MeasurementListResponseDto> getListMeasurement();
    Either<MeasurementResponseDto, Measurement> getMeasurementById(Integer idMeasurement);
    void deleteMeasurement(Integer idMeasurement);
}
