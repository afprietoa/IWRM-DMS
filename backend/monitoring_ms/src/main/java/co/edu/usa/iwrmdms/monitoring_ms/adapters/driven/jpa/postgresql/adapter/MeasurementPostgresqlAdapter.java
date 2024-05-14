package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.adapter;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity.MeasurementEntity;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.exceptions.MeasurementNotFoundException;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.exceptions.NoDataFoundException;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.mappers.IMeasurementEntityMapper;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.repositories.IMeasurementRepository;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.MeasurementResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Measurement;
import co.edu.usa.iwrmdms.monitoring_ms.domains.spi.IMeasurementPersistencePort;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class MeasurementPostgresqlAdapter implements IMeasurementPersistencePort {
    private final IMeasurementRepository measurementRepository;
    private final IMeasurementEntityMapper measurementEntityMapper;


    @Override
    public void saveMeasurement(Measurement measurement) {
        measurementRepository.save(measurementEntityMapper.toMeasurementEntity(measurement));
    }

    @Override
    public Page<MeasurementPaginationResponseDto> getPaginationMeasurement(Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(0,pageSize, Sort.by(sortBy).ascending());
        Page<MeasurementEntity> measurementEntityPage = measurementRepository.findAll(pageable);
        return measurementEntityPage.map(measurementEntityMapper::toMeasurementPaginationResponseDto);
    }

    @Override
    public List<MeasurementListResponseDto> getListMeasurement() {
        List<MeasurementEntity> measurementEntityList = measurementRepository.findAll();
        if (measurementEntityList.isEmpty()) throw new NoDataFoundException();
        return measurementEntityList.stream().map(measurementEntityMapper::toMeasurementListResponseDto).toList();
    }

    @Override
    public Either<MeasurementResponseDto, Measurement> getMeasurementById(Integer idMeasurement) {
        MeasurementEntity measurementEntity = measurementRepository.findById(idMeasurement).orElseThrow(MeasurementNotFoundException::new);
        Measurement measurement = measurementEntityMapper.toMeasurement(measurementEntity);
        MeasurementResponseDto measurementResponseDto = measurementEntityMapper.toMeasurementResponseDto(measurementEntity);
        return (measurementResponseDto != null) ? Either.left(measurementResponseDto) : Either.right(measurement);
    }

    @Override
    public void deleteMeasurement(Integer idMeasurement) {
        measurementRepository.deleteById(idMeasurement);
    }
}
