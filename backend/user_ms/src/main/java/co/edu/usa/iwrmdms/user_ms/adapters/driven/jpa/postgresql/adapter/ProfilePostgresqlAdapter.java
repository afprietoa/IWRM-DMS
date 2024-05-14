package co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.adapter;

import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.entity.ProfileEntity;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.exceptions.EmailAlreadyExistsException;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.exceptions.ProfileAlreadyExistsException;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.exceptions.ProfileNotFoundException;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.mappers.IProfileEntityMapper;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.repositories.IProfileRepository;
import co.edu.usa.iwrmdms.user_ms.domains.model.Profile;
import co.edu.usa.iwrmdms.user_ms.domains.spi.IProfilePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class ProfilePostgresqlAdapter implements IProfilePersistencePort {

    private final IProfileRepository profileRepository;
    private final IProfileEntityMapper profileEntityMapper;

    @Override
    public void saveProfile(Profile profile) {
        if(profileRepository.findByDniNumber(profile.getDniNumber()).isPresent())
            throw new ProfileAlreadyExistsException();
        if(profileRepository.existsByEMail(profile.getEmail()))
            throw new EmailAlreadyExistsException();
        profileRepository.save(profileEntityMapper.toEntity(profile));
    }

    @Override
    public Profile getProfileById(Long id) {
        ProfileEntity profileEntity = profileRepository.findById(id).orElseThrow(ProfileNotFoundException::new);
        return profileEntityMapper.toProfile(profileEntity);
    }

}
