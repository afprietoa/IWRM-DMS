package co.edu.usa.iwrmdms.monitoring_ms.configuration;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.adapter.*;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.mappers.*;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.repositories.*;
import co.edu.usa.iwrmdms.monitoring_ms.domains.api.*;
import co.edu.usa.iwrmdms.monitoring_ms.domains.spi.*;
import co.edu.usa.iwrmdms.monitoring_ms.domains.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IResourceRepository resourceRepository;
    private final IResourceEntityMapper resourceEntityMapper;

    private final IPollutantRepository pollutantRepository;
    private final IPollutantEntityMapper pollutantEntityMapper;

    private final IEventRepository eventRepository;
    private final IEventEntityMapper eventEntityMapper;

    private final IMeasurementRepository measurementRepository;
    private final IMeasurementEntityMapper measurementEntityMapper;

    private final IAlertRepository alertRepository;
    private final IAlertEntityMapper alertEntityMapper;

    @Bean
    public IResourcePersistencePort resourcePersistencePort(){return new ResourcePostgresqlAdapter(resourceRepository, resourceEntityMapper);}
    @Bean
    public IResourceServicePort resourceServicePort(){ return new ResourceUseCase(resourcePersistencePort());}


    @Bean
    public IPollutantPersistencePort pollutantPersistencePort(){return new PollutantPostgresqlAdapter(pollutantRepository, pollutantEntityMapper);}
    @Bean
    public IPollutantServicePort pollutantServicePort(){ return new PollutantUseCase(pollutantPersistencePort());}


    @Bean
    public IEventPersistencePort eventPersistencePort(){return new EventPostgresqlAdapter(eventRepository, eventEntityMapper);}
    @Bean
    public IEventServicePort eventServicePort(){ return new EventUseCase(eventPersistencePort());}


    @Bean
    public IMeasurementPersistencePort measurementPersistencePort(){return new MeasurementPostgresqlAdapter(measurementRepository, measurementEntityMapper);}
    @Bean
    public IMeasurementServicePort measurementServicePort(){ return new MeasurementUseCase(measurementPersistencePort());}


    @Bean
    public IAlertPersistencePort alertPersistencePort(){return new AlertPostgresqlAdapter(alertRepository, alertEntityMapper);}
    @Bean
    public IAlertServicePort alertServicePort(){ return new AlertUseCase(alertPersistencePort());}
}
