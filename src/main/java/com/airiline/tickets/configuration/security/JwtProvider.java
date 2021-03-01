package com.airiline.tickets.configuration.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtProvider {

private final JwtConfig jwtConfig;

    public String getUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", userDetails.getAuthorities());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtConfig.getExpirationTime()))
                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecretKey()).compact();
    }

    public boolean validateToken(String token) {
        //TODO Refactor Validation
        Jwts.parser().setSigningKey(jwtConfig.getSecretKey()).parseClaimsJws(token);
        return true;
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(jwtConfig.getSecretKey()).parseClaimsJws(token).getBody();
    }

}
