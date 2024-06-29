package co.edu.usa.iwrmdms.monitoring_ms.domains.spi;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Event;
import io.vavr.control.Either;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEventPersistencePort {
    void saveEvent(Event event);
    Page<EventPaginationResponseDto> getPaginationEvent(Integer pageSize, String sortBy);
    List<EventListResponseDto> getListEvent();
    EventResponseDto getEventById(Integer idEvent);
    void deleteEvent(Integer idEvent);
}
