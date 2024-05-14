package co.edu.usa.iwrmdms.user_ms.adapters.driving.handlers;

import co.edu.usa.iwrmdms.user_ms.adapters.driving.dto.response.RoleResponseDto;

import java.util.List;

public interface IRoleHandler {
    List<RoleResponseDto> getAllRoles();
}
