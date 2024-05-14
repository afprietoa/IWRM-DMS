package co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.adapter;

import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.entity.UserEntity;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.exceptions.*;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.mappers.IUserEntityMapper;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.repositories.IProfileRepository;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.repositories.IRoleRepository;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.repositories.IUserRepository;
import co.edu.usa.iwrmdms.user_ms.domains.model.User;
import co.edu.usa.iwrmdms.user_ms.domains.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import static co.edu.usa.iwrmdms.user_ms.configuration.Constants.*;
import java.util.List;

@RequiredArgsConstructor
@Transactional
public class UserPostgresqlAdapter implements IUserPersistencePort{
    private final IUserRepository userRepository;
    private final IProfileRepository profileRepository;
    private final IRoleRepository roleRepository;
    private final IUserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(User user) {
        if(user.getRole().getRoleId().equals(INSPECTOR_ROLE_ID)) throw new RoleNotAllowedForCreationException();
        if(userRepository.findByProfileEntityIdAndRoleEntityId(user.getProfile().getProfileId(), user.getRole().getRoleId()).isPresent()) throw new UserAlreadyExistsException();
        profileRepository.findById(user.getProfile().getProfileId()).orElseThrow(ProfileNotFoundException::new);
        roleRepository.findById(user.getRole().getRoleId()).orElseThrow(RoleNotFoundException::new);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userEntityMapper.toEntity(user));

    }

    @Override
    public void deleteUser(User user) {
        if(userRepository.findByProfileEntityIdAndRoleEntityId(user.getProfile().getProfileId(), user.getRole().getRoleId()).isPresent())
            userRepository.deleteByProfileEntityIdAndRoleEntityId(user.getProfile().getProfileId(), user.getRole().getRoleId());
        else throw new UserNotFoundException();
    }

    @Override
    public List<User> getAllInspectors(int page) {
        Pageable pagination = PageRequest.of(page, MAX_PAGE_SIZE);
        List<UserEntity> userEntityList = userRepository.findAllByRoleEntityId(INSPECTOR_ROLE_ID, pagination);
        return userEntityMapper.toUserList(userEntityList);
    }

    @Override
    public List<User> getAllSpecialists(int page) {
        Pageable pagination = PageRequest.of(page, MAX_PAGE_SIZE);
        List<UserEntity> userEntityList = userRepository.findAllByRoleEntityId(SPECIALIST_ROLE_ID, pagination);
        return userEntityMapper.toUserList(userEntityList);
    }

    @Override
    public List<User> getAllAssistants(int page) {
        Pageable pagination = PageRequest.of(page, MAX_PAGE_SIZE);
        List<UserEntity> userEntityList = userRepository.findAllByRoleEntityId(ASSISTANT_ROLE_ID, pagination);
        return userEntityMapper.toUserList(userEntityList);
    }

    @Override
    public List<User> getAllVolunteers(int page) {
        Pageable pagination = PageRequest.of(page, MAX_PAGE_SIZE);
        List<UserEntity> userEntityList = userRepository.findAllByRoleEntityId(VOLUNTEER_ROLE_ID, pagination);
        return userEntityMapper.toUserList(userEntityList);
    }

    @Override
    public User getInspector(Long id) {
        UserEntity userEntity = userRepository.findByProfileEntityIdAndRoleEntityId(id, INSPECTOR_ROLE_ID).orElseThrow(UserNotFoundException::new);
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public User getSpecialist(Long id) {
        UserEntity userEntity = userRepository.findByProfileEntityIdAndRoleEntityId(id, SPECIALIST_ROLE_ID).orElseThrow(UserNotFoundException::new);
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public User getAssistant(Long id) {
        UserEntity userEntity = userRepository.findByProfileEntityIdAndRoleEntityId(id, ASSISTANT_ROLE_ID).orElseThrow(UserNotFoundException::new);
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public User getVolunteer(Long id) {
        UserEntity userEntity = userRepository.findByProfileEntityIdAndRoleEntityId(id, VOLUNTEER_ROLE_ID).orElseThrow(UserNotFoundException::new);
        return userEntityMapper.toUser(userEntity);
    }
}
