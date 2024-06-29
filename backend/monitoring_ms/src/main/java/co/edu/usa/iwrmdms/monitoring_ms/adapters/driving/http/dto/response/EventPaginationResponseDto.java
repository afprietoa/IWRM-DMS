package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response;

import co.edu.usa.iwrmdms.monitoring_ms.domains.model.enums.Magnitude;

import java.time.LocalDate;

public record EventPaginationResponseDto(
        String description,
        Magnitude magnitude,
        LocalDate date,
        PollutantResponseDto pollutant,
        ResourceResponseDto resource
) {
}
