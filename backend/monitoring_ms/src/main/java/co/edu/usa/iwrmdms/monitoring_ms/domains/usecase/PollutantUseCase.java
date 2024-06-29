package co.edu.usa.iwrmdms.monitoring_ms.domains.usecase;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper.IPollutantResponseMapper;
import co.edu.usa.iwrmdms.monitoring_ms.domains.api.IPollutantServicePort;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Pollutant;
import co.edu.usa.iwrmdms.monitoring_ms.domains.spi.IPollutantPersistencePort;
import org.springframework.data.domain.Page;

import java.util.List;

public class PollutantUseCase implements IPollutantServicePort {
    private final IPollutantPersistencePort pollutantPersistencePort;
    private final IPollutantResponseMapper pollutantResponseMapper;
    public PollutantUseCase(IPollutantPersistencePort pollutantPersistencePort, IPollutantResponseMapper pollutantResponseMapper) {
        this.pollutantPersistencePort = pollutantPersistencePort;
        this.pollutantResponseMapper = pollutantResponseMapper;
    }

    @Override
    public void createPollutant(Pollutant pollutant) {
        pollutantPersistencePort.savePollutant(pollutant);
    }

    @Override
    public void updatePollutant(Pollutant pollutant) {
        Pollutant tempPollutant = pollutantResponseMapper.toPollutant(this.getPollutant(pollutant.getPollutantId()));
        tempPollutant.setName(pollutant.getName());
        tempPollutant.setLoad(pollutant.getLoad());
        pollutantPersistencePort.savePollutant(tempPollutant);
    }

    @Override
    public Page<PollutantPaginationResponseDto> getPaginationPollutant(Integer pageSize, String sortBy) {
        return pollutantPersistencePort.getPaginationPollutant(pageSize, sortBy);
    }

    @Override
    public List<PollutantListResponseDto> getListPollutant() {
        return pollutantPersistencePort.getListPollutant();
    }

    @Override
    public PollutantResponseDto getPollutant(Integer idPollutant) {
        return pollutantPersistencePort.getPollutantById(idPollutant);
    }

    @Override
    public void deletePollutant(Integer idPollutant) {
        pollutantPersistencePort.deletePollutant(idPollutant);
    }
}
