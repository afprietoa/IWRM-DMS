package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request;

import java.time.LocalDate;

public record MeasurementCreateRequestDto(
        LocalDate date,
        Float ph,
        Float temperature,
        Integer userId,
        Integer pollutantId,
        Integer resourceId
) {
}
