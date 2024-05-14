package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request;

import co.edu.usa.iwrmdms.monitoring_ms.domains.model.enums.Level;

import java.time.LocalDate;

public record AlertCreateRequestDto(
        LocalDate date,
        Level level,
        String message,
        Integer userId,
        Integer eventId
) {
}
