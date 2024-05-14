package co.edu.usa.iwrmdms.user_ms.adapters.driving.handlers.impl;

import co.edu.usa.iwrmdms.user_ms.adapters.driving.dto.response.RoleResponseDto;
import co.edu.usa.iwrmdms.user_ms.adapters.driving.handlers.IRoleHandler;
import co.edu.usa.iwrmdms.user_ms.adapters.driving.mappers.IRoleResponseMapper;
import co.edu.usa.iwrmdms.user_ms.domains.api.IRoleServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleHandlerImpl implements IRoleHandler {
    private final IRoleResponseMapper roleResponseMapper;
    private final IRoleServicePort roleServicePort;


    @Override
    public List<RoleResponseDto> getAllRoles() {
        return roleResponseMapper.toResponseList(roleServicePort.getAllRoles());
    }
}
