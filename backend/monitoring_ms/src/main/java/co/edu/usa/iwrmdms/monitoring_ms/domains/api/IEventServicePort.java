package co.edu.usa.iwrmdms.monitoring_ms.domains.api;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Event;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEventServicePort {
    void createEvent(Event event);
    void updateEvent(Event event);
    Page<EventPaginationResponseDto> getPaginationEvent(Integer pageSize, String sortBy);
    List<EventListResponseDto> getListEvent();
    EventResponseDto getEvent(Integer idEvent);
    void deleteEvent(Integer idEvent);
}
