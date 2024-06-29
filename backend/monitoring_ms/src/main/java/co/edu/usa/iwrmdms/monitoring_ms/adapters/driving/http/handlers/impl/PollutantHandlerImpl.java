package co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers.impl;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.PollutantCreateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.request.PollutantUpdateRequestDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantListResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantPaginationResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.dto.response.PollutantResponseDto;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.handlers.IPollutantHandler;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper.IPollutantRequestMapper;
import co.edu.usa.iwrmdms.monitoring_ms.adapters.driving.http.mapper.IResourceRequestMapper;
import co.edu.usa.iwrmdms.monitoring_ms.domains.api.IPollutantServicePort;
import co.edu.usa.iwrmdms.monitoring_ms.domains.api.IResourceServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PollutantHandlerImpl implements IPollutantHandler {

    private final IPollutantServicePort pollutantServicePort;

    private final IPollutantRequestMapper pollutantRequestMapper;
    @Override
    public void createPollutant(PollutantCreateRequestDto pollutantCreateRequestDto) {
        pollutantServicePort.createPollutant(pollutantRequestMapper.toCreatePollutant(pollutantCreateRequestDto));
    }

    @Override
    public void updatePollutant(PollutantUpdateRequestDto pollutantUpdateRequestDto) {
        pollutantServicePort.updatePollutant(pollutantRequestMapper.toUpdatePollutant(pollutantUpdateRequestDto));
    }

    @Override
    public Page<PollutantPaginationResponseDto> getPaginationPollutant(Integer pageSize, String sortBy) {
        return pollutantServicePort.getPaginationPollutant(pageSize,sortBy);
    }

    @Override
    public List<PollutantListResponseDto> getListPollutant() {

        return pollutantServicePort.getListPollutant();
    }

    @Override
    public PollutantResponseDto getPollutant(Integer idPollutant) {
        return pollutantServicePort.getPollutant(idPollutant);
    }

    @Override
    public void deletePollutant(Integer idPollutant) {
        pollutantServicePort.deletePollutant(idPollutant);
    }
}
