package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.EventCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.EventUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IEventRequestMapper {
    Event toCreateEvent(EventCreateRequestDto eventCreateRequestDto);
    Event toUpdateEvent(EventUpdateRequestDto eventUpdateRequestDto);
}
