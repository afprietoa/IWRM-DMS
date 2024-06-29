package co.edu.usa.iwrmdms.monitoring_ms.domains.api;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.domains.model.Pollutant;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPollutantServicePort {
    void createPollutant(Pollutant pollutant);
    void updatePollutant(Pollutant pollutant);
    Page<PollutantPaginationResponseDto> getPaginationPollutant(Integer pageSize, String sortBy);
    List<PollutantListResponseDto> getListPollutant();
    PollutantResponseDto getPollutant(Integer idPollutant);
    void deletePollutant(Integer idPollutant);
}
