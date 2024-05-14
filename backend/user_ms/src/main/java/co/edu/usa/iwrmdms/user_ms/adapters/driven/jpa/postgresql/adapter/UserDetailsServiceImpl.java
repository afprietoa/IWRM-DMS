package co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.adapter;

import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.entity.PrincipalUser;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.entity.ProfileEntity;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.entity.RoleEntity;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.entity.UserEntity;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.exceptions.ProfileNotFoundException;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.repositories.IProfileRepository;
import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IProfileRepository profileRepository;


    @Override
    public UserDetails loadUserByUsername(String dniNumber) throws UsernameNotFoundException {
        ProfileEntity profile = profileRepository.findByDniNumber(dniNumber).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Optional<UserEntity> user = userRepository.findByProfileEntityId(profile.getProfileId());
        if (!user.isPresent()) throw new UsernameNotFoundException("User not found with document: "+ dniNumber);
        List<RoleEntity> roles = new ArrayList<>();
        roles.add(user.get().getRole());
        return PrincipalUser.build(user.get(), roles);
    }
}
