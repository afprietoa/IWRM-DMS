package co.edu.usa.iwrmdms.user_ms.adapters.driving.handlers;

import co.edu.usa.iwrmdms.user_ms.adapters.driving.dto.request.UserRequestDto;
import co.edu.usa.iwrmdms.user_ms.adapters.driving.dto.response.ProfileResponseDto;

import java.util.List;

public interface IUserHandler {
    void saveUser(UserRequestDto userRequestDto);
    void deleteUser(UserRequestDto userRequestDto);

    List<ProfileResponseDto> getInspectors(Integer page);

    List<ProfileResponseDto> getSpecialists(Integer page);
    List<ProfileResponseDto> getAssistants(Integer page);
    List<ProfileResponseDto> getVolunteers(Integer page);
    ProfileResponseDto getInspector(Long id);
    ProfileResponseDto getSpecialist(Long id);
    ProfileResponseDto getAssistant(Long id);
    ProfileResponseDto getVolunteer(Long id);
}
