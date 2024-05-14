package co.edu.usa.iwrmdms.user_ms.configuration.security.jwt;

import co.edu.usa.iwrmdms.user_ms.adapters.driven.jpa.postgresql.entity.PrincipalUser;
import co.edu.usa.iwrmdms.user_ms.adapters.driving.dto.response.JwtResponseDto;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.SignatureException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secret.getBytes()).build().parseClaimsJws(token);
            return true;
        }catch(MalformedJwtException e){
            logger.error("token mal formed");
        }catch(UnsupportedJwtException e){
            logger.error("token didn't support");
        }catch(ExpiredJwtException e){
            logger.error("token expired");
        }catch(IllegalArgumentException e){
            logger.error("Empty token");
        }
        return false;
    }
    public String generateToken(Authentication authentication){
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        List<String> roles = principalUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        Key secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts.builder()
                .setSubject(principalUser.getUsername())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 180))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String refreshToken(JwtResponseDto jwtResponseDto) throws ParseException{
        try{
            Jwts.parserBuilder().setSigningKey(secret.getBytes()).build().parseClaimsJws(jwtResponseDto.getToken()).getBody();
        }catch (ExpiredJwtException e){
            JWT jwt = JWTParser.parse(jwtResponseDto.getToken());
            JWTClaimsSet claimsSet = jwt.getJWTClaimsSet();
            String username = claimsSet.getSubject();
            List<String> roles = claimsSet.getStringListClaim("roles");
            Key secretKey = Keys.hmacShaKeyFor(secret.getBytes());
            return Jwts.builder()
                    .setSubject(username)
                    .claim("roles", roles)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(new Date().getTime() + expiration * 180))
                    .signWith(secretKey, SignatureAlgorithm.HS256)
                    .compact();
        }
        return null;
    }

    public String getSubjectFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(secret.getBytes()).build().parseClaimsJws(token).getBody().getSubject();
    }
}
