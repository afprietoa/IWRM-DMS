package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.EventCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.EventUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventResponseDto;
import org.springframework.data.domain.Page;


import java.util.List;

public interface IEventHandler {
    void createEvent(EventCreateRequestDto eventCreateRequestDto);
    void updateEvent(Integer idEvent, EventUpdateRequestDto eventUpdateRequestDto);
    Page<EventPaginationResponseDto> getPaginationEvent(Integer pageSize, String sortBy);
    List<EventListResponseDto> getListEvent();
    EventResponseDto getEvent(Integer idEvent);
    void deleteEvent(Integer idEvent);
}
