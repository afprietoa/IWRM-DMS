package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request;

public record PollutantCreateRequestDto(
        String name,
        Float load
) {
}
