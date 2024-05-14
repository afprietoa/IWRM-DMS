package co.edu.usa.iwrmdms.user_ms.adapters.driving.handlers.impl;

import co.edu.usa.iwrmdms.user_ms.adapters.driving.dto.request.LoginRequestDto;
import co.edu.usa.iwrmdms.user_ms.adapters.driving.dto.response.JwtResponseDto;
import co.edu.usa.iwrmdms.user_ms.adapters.driving.handlers.IAuthHandler;
import co.edu.usa.iwrmdms.user_ms.configuration.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
@RequiredArgsConstructor
public class AuthHandlerImpl implements IAuthHandler {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Override
    public JwtResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return new JwtResponseDto(jwt);
    }

    @Override
    public JwtResponseDto refresh(JwtResponseDto jwtResponseDto) throws ParseException {
        String token = jwtProvider.refreshToken(jwtResponseDto);
        return new JwtResponseDto(token);
    }
}
