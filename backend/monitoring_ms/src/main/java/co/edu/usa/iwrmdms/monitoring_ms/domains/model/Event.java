package co.edu.usa.iwrmdms.monitoring_ms.domains.model;

import co.edu.usa.iwrmdms.monitoring_ms.domains.model.enums.Magnitude;

import java.time.LocalDate;

public class Event {
    private Integer eventId;
    private String description;
    private Magnitude magnitude;
    private LocalDate date;
    private Integer pollutantId;
    private Integer resourceId;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Magnitude getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
