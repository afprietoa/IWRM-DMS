package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request;

import co.edu.usa.iwrmdms.monitoring_ms.domains.model.enums.Level;

import java.time.LocalDate;

public record AlertUpdateRequestDto(
        Integer alertId,
        LocalDate date,
        Level level,
        String message,
        Integer userId,
        Integer eventId
) {
    @Override
    public Integer alertId() {
        return alertId;
    }

    @Override
    public LocalDate date() {
        return date;
    }

    @Override
    public Level level() {
        return level;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public Integer userId() {
        return userId;
    }

    @Override
    public Integer eventId() {
        return eventId;
    }
}
