package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.adapter;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity.AlertEntity;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.exceptions.AlertNotFoundException;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.exceptions.NoDataFoundException;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.mappers.IAlertEntityMapper;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.repositories.IAlertRepository;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.AlertResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Alert;
import co.edu.usa.iwrmdms.monitoring_ms.domains.spi.IAlertPersistencePort;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class AlertPostgresqlAdapter implements IAlertPersistencePort {
    private final IAlertRepository alertRepository;
    private final IAlertEntityMapper alertEntityMapper;


    @Override
    public void saveAlert(Alert alert) {
        alertRepository.save(alertEntityMapper.toAlertEntity(alert));
    }

    @Override
    public Page<AlertPaginationResponseDto> getPaginationAlert(Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(0,pageSize, Sort.by(sortBy).ascending());
        Page<AlertEntity> alertEntityPage = alertRepository.findAll(pageable);
        return alertEntityPage.map(alertEntityMapper::toAlertPaginationResponseDto);
    }

    @Override
    public List<AlertListResponseDto> getListAlert() {
        List<AlertEntity> alertEntityList = alertRepository.findAll();
        if (alertEntityList.isEmpty()) throw new NoDataFoundException();
        return alertEntityList.stream().map(alertEntityMapper::toAlertListResponseDto).toList();
    }

    @Override
    public Either<AlertResponseDto, Alert> getAlertById(Integer idAlert) {
        AlertEntity alertEntity = alertRepository.findById(idAlert).orElseThrow(AlertNotFoundException::new);
        Alert alert = alertEntityMapper.toAlert(alertEntity);
        AlertResponseDto alertResponseDto = alertEntityMapper.toAlertResponseDto(alertEntity);
        return (alertResponseDto != null) ? Either.left(alertResponseDto) : Either.right(alert);
    }

    @Override
    public void deleteAlert(Integer idAlert) {
        alertRepository.deleteById(idAlert);
    }
}
