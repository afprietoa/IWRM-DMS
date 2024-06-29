package co.edu.usa.iwrmdms.monitoring_ms.domains.usecase;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper.IEventResponseMapper;
import co.edu.usa.iwrmdms.monitoring_ms.domains.api.IEventServicePort;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Event;
import co.edu.usa.iwrmdms.monitoring_ms.domains.spi.IEventPersistencePort;
import org.springframework.data.domain.Page;

import java.util.List;

public class EventUseCase implements IEventServicePort {
    private final IEventPersistencePort eventPersistencePort;
    private final IEventResponseMapper eventResponseMapper;

    public EventUseCase(IEventPersistencePort eventPersistencePort, IEventResponseMapper eventResponseMapper) {
        this.eventPersistencePort = eventPersistencePort;
        this.eventResponseMapper = eventResponseMapper;
    }

    @Override
    public void createEvent(Event event) {
        eventPersistencePort.saveEvent(event);
    }

    @Override
    public void updateEvent(Event event) {
        Event tempEvent = eventResponseMapper.toEvent(this.getEvent(event.getEventId()));
        tempEvent.setDescription(event.getDescription());
        tempEvent.setMagnitude(event.getMagnitude());
        tempEvent.setDate(event.getDate());
        tempEvent.setPollutantId(event.getPollutantId());
        tempEvent.setResourceId(event.getResourceId());
        eventPersistencePort.saveEvent(tempEvent);
    }

    @Override
    public Page<EventPaginationResponseDto> getPaginationEvent(Integer pageSize, String sortBy) {
        return eventPersistencePort.getPaginationEvent(pageSize, sortBy);
    }

    @Override
    public List<EventListResponseDto> getListEvent() {
        return eventPersistencePort.getListEvent();
    }

    @Override
    public EventResponseDto getEvent(Integer idEvent) {
        return eventPersistencePort.getEventById(idEvent);
    }

    @Override
    public void deleteEvent(Integer idEvent) {
        eventPersistencePort.deleteEvent(idEvent);
    }
}
