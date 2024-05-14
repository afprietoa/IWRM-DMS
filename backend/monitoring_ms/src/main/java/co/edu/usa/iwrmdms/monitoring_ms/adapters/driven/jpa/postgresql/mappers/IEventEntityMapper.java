package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.mappers;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity.EventEntity;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IEventEntityMapper {
    EventEntity toEventEntity(Event event);
    Event toEvent(EventEntity eventEntity);
    EventResponseDto toEventResponseDto(EventEntity eventEntity);
    EventPaginationResponseDto toEventPaginationResponseDto(EventEntity eventEntity);
    EventListResponseDto toEventListResponseDto(EventEntity eventEntity);
}
