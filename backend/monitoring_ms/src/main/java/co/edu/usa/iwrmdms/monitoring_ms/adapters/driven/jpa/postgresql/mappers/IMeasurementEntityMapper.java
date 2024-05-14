package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.mappers;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity.MeasurementEntity;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Measurement;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMeasurementEntityMapper {
    MeasurementEntity toMeasurementEntity(Measurement measurement);
    Measurement toMeasurement(MeasurementEntity measurementEntity);
    MeasurementResponseDto toMeasurementResponseDto(MeasurementEntity measurementEntity);
    MeasurementPaginationResponseDto toMeasurementPaginationResponseDto(MeasurementEntity measurementEntity);
    MeasurementListResponseDto toMeasurementListResponseDto(MeasurementEntity measurementEntity);
}
