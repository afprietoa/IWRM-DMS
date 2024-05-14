package co.edu.usa.iwrmdms.user_ms.domains.usecase;

import co.edu.usa.iwrmdms.user_ms.domains.api.IProfileServicePort;
import co.edu.usa.iwrmdms.user_ms.domains.model.Profile;
import co.edu.usa.iwrmdms.user_ms.domains.spi.IProfilePersistencePort;

public class ProfileUseCase implements IProfileServicePort {

    private final IProfilePersistencePort profilePersistencePort;

    public ProfileUseCase(IProfilePersistencePort profilePersistencePort) {
        this.profilePersistencePort = profilePersistencePort;
    }

    @Override
    public void saveProfile(Profile profile) {
        profilePersistencePort.saveProfile(profile);
    }

    @Override
    public void updateProfile(Long idProfile, Profile profile) {
        Profile tempProfile = profilePersistencePort.getProfileById(idProfile);
        tempProfile.setDniType(profile.getDniType());
        tempProfile.setDniNumber(profile.getDniNumber());
        tempProfile.setFirstName(profile.getFirstName());
        tempProfile.setLastName(profile.getLastName());
        tempProfile.setEmail(profile.getEmail());
        tempProfile.setPhone(profile.getPhone());
        tempProfile.setAddress(profile.getAddress());
        tempProfile.setAcademicDegree(profile.getAcademicDegree());
        tempProfile.setOccupation(profile.getOccupation());
        profilePersistencePort.saveProfile(tempProfile);
    }

}
