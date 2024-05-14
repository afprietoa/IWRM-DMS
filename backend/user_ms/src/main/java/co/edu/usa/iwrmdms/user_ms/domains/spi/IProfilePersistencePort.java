package co.edu.usa.iwrmdms.user_ms.domains.spi;

import co.edu.usa.iwrmdms.user_ms.domains.model.Profile;

public interface IProfilePersistencePort {
    void saveProfile(Profile profile);


    Profile getProfileById(Long id);
}
