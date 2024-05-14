package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response;

import java.time.LocalDate;

public record MeasurementPaginationResponseDto(
        LocalDate date,
        Float ph,
        Float temperature,
        Integer userId,
        Integer pollutantId,
        Integer resourceId
) {
}
