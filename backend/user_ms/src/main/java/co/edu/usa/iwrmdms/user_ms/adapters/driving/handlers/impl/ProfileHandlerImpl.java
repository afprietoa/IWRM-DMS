package co.edu.usa.iwrmdms.user_ms.adapters.driving.handlers.impl;

import co.edu.usa.iwrmdms.user_ms.adapters.driving.dto.request.ProfileRequestDto;
import co.edu.usa.iwrmdms.user_ms.adapters.driving.handlers.IProfileHandler;
import co.edu.usa.iwrmdms.user_ms.adapters.driving.mappers.IProfileRequestMapper;
import co.edu.usa.iwrmdms.user_ms.domains.api.IProfileServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileHandlerImpl implements IProfileHandler {
    private final IProfileRequestMapper profileRequestMapper;
    private final IProfileServicePort profileServicePort;


    @Override
    public void createProfile(ProfileRequestDto profileRequestDto) {
        profileServicePort.saveProfile(profileRequestMapper.toProfile(profileRequestDto));
    }

    @Override
    public void updateProfile(Long id, ProfileRequestDto profileRequestDto) {
        profileServicePort.updateProfile(id, profileRequestMapper.toProfile(profileRequestDto));
    }
}
