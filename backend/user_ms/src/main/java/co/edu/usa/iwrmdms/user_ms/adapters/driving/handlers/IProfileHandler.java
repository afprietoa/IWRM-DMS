package co.edu.usa.iwrmdms.user_ms.adapters.driving.handlers;

import co.edu.usa.iwrmdms.user_ms.adapters.driving.dto.request.ProfileRequestDto;

public interface IProfileHandler {
    void createProfile(ProfileRequestDto profileRequestDto);
    void updateProfile(Long id,ProfileRequestDto profileRequestDto);
}
