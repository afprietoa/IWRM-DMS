package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request;

public record PollutantUpdateRequestDto(
        Integer pollutantId,
        String name,
        Float load
) {
    @Override
    public Integer pollutantId() {
        return pollutantId;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Float load() {
        return load;
    }
}
