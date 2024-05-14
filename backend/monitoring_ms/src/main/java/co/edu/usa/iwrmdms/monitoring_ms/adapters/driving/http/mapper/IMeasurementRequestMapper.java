package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.MeasurementCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.MeasurementUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Measurement;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMeasurementRequestMapper {
    Measurement toCreateMeasurement(MeasurementCreateRequestDto measurementCreateRequestDto);
    Measurement toUpdateMeasurement(MeasurementUpdateRequestDto measurementUpdateRequestDto);
}
