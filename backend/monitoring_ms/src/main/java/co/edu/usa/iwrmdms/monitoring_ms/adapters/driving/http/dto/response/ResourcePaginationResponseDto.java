package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response;

import co.edu.usa.iwrmdms.monitoring_ms.domains.model.enums.Type;

public record ResourcePaginationResponseDto(
        String name,
        Type type,
        Float latitude,
        Float longitude,
        String location
) {
}
