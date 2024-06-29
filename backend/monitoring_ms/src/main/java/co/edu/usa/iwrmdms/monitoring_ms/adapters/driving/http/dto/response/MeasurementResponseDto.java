package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response;

import java.time.LocalDate;

public record MeasurementResponseDto(
        Integer measurementId,
        LocalDate date,
        Float ph,
        Float temperature,
        Integer userId,
        PollutantResponseDto pollutant,
        ResourceResponseDto resource
) {
}
