package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.PollutantCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.PollutantUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantResponseDto;
import org.springframework.data.domain.Page;


import java.util.List;
public interface IPollutantHandler {
    void createPollutant(PollutantCreateRequestDto pollutantCreateRequestDto);
    void updatePollutant(Integer idPollutant, PollutantUpdateRequestDto pollutantUpdateRequestDto);
    Page<PollutantPaginationResponseDto> getPaginationPollutant(Integer pageSize, String sortBy);
    List<PollutantListResponseDto> getListPollutant();
    PollutantResponseDto getPollutant(Integer idPollutant);
    void deletePollutant(Integer idPollutant);
}
