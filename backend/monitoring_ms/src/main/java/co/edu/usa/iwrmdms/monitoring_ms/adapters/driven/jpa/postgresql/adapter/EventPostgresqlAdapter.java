package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.adapter;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity.EventEntity;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.exceptions.EvemtNotFoundException;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.exceptions.NoDataFoundException;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.mappers.IEventEntityMapper;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.repositories.IEventRepository;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.EventResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Event;
import co.edu.usa.iwrmdms.monitoring_ms.domains.spi.IEventPersistencePort;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class EventPostgresqlAdapter implements IEventPersistencePort {
    private final IEventRepository eventRepository;
    private final IEventEntityMapper eventEntityMapper;


    @Override
    public void saveEvent(Event event) {
        eventRepository.save(eventEntityMapper.toEventEntity(event));
    }

    @Override
    public Page<EventPaginationResponseDto> getPaginationEvent(Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(0,pageSize, Sort.by(sortBy).ascending());
        Page<EventEntity> eventEntityPage = eventRepository.findAll(pageable);
        return eventEntityPage.map(eventEntityMapper::toEventPaginationResponseDto);
    }

    @Override
    public List<EventListResponseDto> getListEvent() {
        List<EventEntity> eventEntityList = eventRepository.findAll();
        if (eventEntityList.isEmpty()) throw new NoDataFoundException();
        return eventEntityList.stream().map(eventEntityMapper::toEventListResponseDto).toList();
    }

    @Override
    public Either<EventResponseDto, Event> getEventById(Integer idEvent) {
        EventEntity eventEntity = eventRepository.findById(idEvent).orElseThrow(EvemtNotFoundException::new);
        Event event = eventEntityMapper.toEvent(eventEntity);
        EventResponseDto eventResponseDto = eventEntityMapper.toEventResponseDto(eventEntity);
        return (eventResponseDto != null) ? Either.left(eventResponseDto) : Either.right(event);
    }

    @Override
    public void deleteEvent(Integer idEvent) {
        eventRepository.deleteById(idEvent);
    }
}