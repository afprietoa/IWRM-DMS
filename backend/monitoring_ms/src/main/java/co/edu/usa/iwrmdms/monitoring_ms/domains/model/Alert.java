package co.edu.usa.iwrmdms.monitoring_ms.domains.model;

import co.edu.usa.iwrmdms.monitoring_ms.domains.model.enums.Level;

import java.time.LocalDate;

public class Alert {
    private Integer alertId;
    private LocalDate date;
    private Level level;
    private String message;
    private Integer userId;
    private Integer eventId;

    public Integer getAlertId() {
        return alertId;
    }

    public void setAlertId(Integer alertId) {
        this.alertId = alertId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }
}
