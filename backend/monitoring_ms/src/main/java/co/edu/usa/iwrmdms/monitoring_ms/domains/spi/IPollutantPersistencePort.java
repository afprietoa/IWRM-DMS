package co.edu.usa.iwrmdms.monitoring_ms.domains.spi;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.mappers.IPollutantEntityMapper;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Pollutant;
import io.vavr.control.Either;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPollutantPersistencePort {
    void savePollutant(Pollutant pollutant);
    Page<PollutantPaginationResponseDto> getPaginationPollutant(Integer pageSize, String sortBy);
    List<PollutantListResponseDto> getListPollutant();
    PollutantResponseDto getPollutantById(Integer idPollutant);
    void deletePollutant(Integer idPollutant);
}
