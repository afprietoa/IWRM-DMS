package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.adapter;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity.PollutantEntity;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.exceptions.NoDataFoundException;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.exceptions.PollutantNotFoundException;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.mappers.IPollutantEntityMapper;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.repositories.IPollutantRepository;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Pollutant;
import co.edu.usa.iwrmdms.monitoring_ms.domains.spi.IPollutantPersistencePort;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class PollutantPostgresqlAdapter implements IPollutantPersistencePort {
    private final IPollutantRepository pollutantRepository;
    private final IPollutantEntityMapper pollutantEntityMapper;


    @Override
    public void savePollutant(Pollutant pollutant) {
        pollutantRepository.save(pollutantEntityMapper.toPollutantEntity(pollutant));
    }

    @Override
    public Page<PollutantPaginationResponseDto> getPaginationPollutant(Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(0,pageSize, Sort.by(sortBy).ascending());
        Page<PollutantEntity> pollutantEntityPage = pollutantRepository.findAll(pageable);
        return pollutantEntityPage.map(pollutantEntityMapper::toPollutantPaginationResponseDto);
    }

    @Override
    public List<PollutantListResponseDto> getListPollutant() {
        List<PollutantEntity> pollutantEntityList = pollutantRepository.findAll();
        if (pollutantEntityList.isEmpty()) throw new NoDataFoundException();
        return pollutantEntityList.stream().map(pollutantEntityMapper::toPollutantListResponseDto).toList();
    }

    @Override
    public Either<PollutantResponseDto, Pollutant> getPollutantById(Integer idPollutant) {
        PollutantEntity pollutantEntity = pollutantRepository.findById(idPollutant).orElseThrow(PollutantNotFoundException::new);
        Pollutant pollutant = pollutantEntityMapper.toPollutant(pollutantEntity);
        PollutantResponseDto pollutantResponseDto = pollutantEntityMapper.toPollutantResponseDto(pollutantEntity);
        return (pollutantResponseDto != null) ? Either.left(pollutantResponseDto) : Either.right(pollutant);
    }

    @Override
    public void deletePollutant(Integer idPollutant) {
        pollutantRepository.deleteById(idPollutant);
    }
}
