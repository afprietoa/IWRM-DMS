package co.edu.usa.iwrmdms.monitoring_ms.domains.model;

import java.time.LocalDate;

public class Measurement {
    private Integer measurementId;
    private LocalDate date;
    private Float ph;
    private Float temperature;
    private Integer userId;
    private Integer pollutantId;
    private Integer resourceId;

    public Integer getMeasurementId() {
        return measurementId;
    }

    public void setMeasurementId(Integer measurementId) {
        this.measurementId = measurementId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Float getPh() {
        return ph;
    }

    public void setPh(Float ph) {
        this.ph = ph;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPollutantId() {
        return pollutantId;
    }

    public void setPollutantId(Integer pollutantId) {
        this.pollutantId = pollutantId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
}
