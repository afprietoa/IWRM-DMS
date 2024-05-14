package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request;

import java.time.LocalDate;

public record MeasurementUpdateRequestDto(
        Integer measurementId,
        LocalDate date,
        Float ph,
        Float temperature,
        Integer userId,
        Integer pollutantId,
        Integer resourceId
) {
    @Override
    public Integer measurementId() {
        return measurementId;
    }

    @Override
    public LocalDate date() {
        return date;
    }

    @Override
    public Float ph() {
        return ph;
    }

    @Override
    public Float temperature() {
        return temperature;
    }

    @Override
    public Integer userId() {
        return userId;
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
