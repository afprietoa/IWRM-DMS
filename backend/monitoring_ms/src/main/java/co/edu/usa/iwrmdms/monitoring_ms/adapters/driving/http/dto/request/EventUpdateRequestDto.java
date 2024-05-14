package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request;

import co.edu.usa.iwrmdms.monitoring_ms.domains.model.enums.Magnitude;

import java.time.LocalDate;

public record EventUpdateRequestDto(
        Integer eventId,
        String description,
        Magnitude magnitude,
        LocalDate date,
        Integer pollutantId,
        Integer resourceId
) {
    @Override
    public Integer eventId() {
        return eventId;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public Magnitude magnitude() {
        return magnitude;
    }

    @Override
    public LocalDate date() {
        return date;
    }

    @Override
    public Integer pollutantId() {
        return pollutantId;
    }

    @Override
    public Integer resourceId() {
        return resourceId;
    }
}
