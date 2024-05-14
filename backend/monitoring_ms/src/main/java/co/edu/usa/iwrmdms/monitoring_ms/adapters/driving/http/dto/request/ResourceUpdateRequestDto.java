package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request;

import co.edu.usa.iwrmdms.monitoring_ms.domains.model.enums.Type;

public record ResourceUpdateRequestDto(
        Integer resourceId,
        String name,
        Type type,
        Float latitude,
        Float longitude,
        String location
) {
    @Override
    public Integer resourceId() {
        return resourceId;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Type type() {
        return type;
    }

    @Override
    public Float latitude() {
        return latitude;
    }

    @Override
    public Float longitude() {
        return longitude;
    }

    @Override
    public String location() {
        return location;
    }
}
