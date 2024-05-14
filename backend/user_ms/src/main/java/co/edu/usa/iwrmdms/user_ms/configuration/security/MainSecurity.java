package co.edu.usa.iwrmdms.user_ms.configuration.security;

import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.adapter.UserDetailsServiceImpl;
import co.edu.usa.iwrmdms.user_ms.configuration.security.jwt.JwtEntryPoint;
import co.edu.usa.iwrmdms.user_ms.configuration.security.jwt.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static co.edu.usa.iwrmdms.user_ms.configuration.Constants.*;

@Configuration
@EnableWebSecurity
public class MainSecurity {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    JwtEntryPoint jwtEntryPoint;

    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .cors(cors -> cors.disable())
                .csrf(csrf -> csrf.disable())
                .formLogin( formLogin -> formLogin.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests( request -> request
                        .requestMatchers("/swagger-ui.html","/swagger-ui/**","/v3/api-docs/**","/actuator/health").permitAll()
                        .requestMatchers(HttpMethod.POST,"/user/create/").hasAuthority(ADMINISTRATOR_ROLE)
                        .anyRequest().authenticated()
                )
                .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtEntryPoint))
                .addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
