package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers.impl;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.EventCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.EventUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers.IEventHandler;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper.IEventRequestMapper;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper.IMeasurementRequestMapper;
import co.edu.usa.iwrmdms.monitoring_ms.domains.api.IEventServicePort;
import co.edu.usa.iwrmdms.monitoring_ms.domains.api.IMeasurementServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventHandlerImpl implements IEventHandler {
    private final IEventServicePort eventServicePort;

    private final IEventRequestMapper eventRequestMapper;
    @Override
    public void createEvent(EventCreateRequestDto eventCreateRequestDto) {
        eventServicePort.createEvent(eventRequestMapper.toCreateEvent(eventCreateRequestDto));
    }

    @Override
    public void updateEvent(EventUpdateRequestDto eventUpdateRequestDto) {
        eventServicePort.updateEvent(eventRequestMapper.toUpdateEvent(eventUpdateRequestDto));
    }

    @Override
    public Page<EventPaginationResponseDto> getPaginationEvent(Integer pageSize, String sortBy) {
        return eventServicePort.getPaginationEvent(pageSize, sortBy);
    }

    @Override
    public List<EventListResponseDto> getListEvent() {
        return eventServicePort.getListEvent();
    }

    @Override
    public EventResponseDto getEvent(Integer idEvent) {
        return eventServicePort.getEvent(idEvent);
    }

    @Override
    public void deleteEvent(Integer idEvent) {
        eventServicePort.deleteEvent(idEvent);
    }
}
