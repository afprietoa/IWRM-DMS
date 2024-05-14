package co.edu.usa.iwrmdms.user_ms.domains.api;

import co.edu.usa.iwrmdms.user_ms.domains.model.Profile;

public interface IProfileServicePort {
    void saveProfile(Profile profile);
    void updateProfile(Long idProfile, Profile profile);

}
