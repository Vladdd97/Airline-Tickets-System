package com.airiline.tickets.dto.auth;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@Builder
public class SignInResponse {
    private String token;
    private final String type = "Bearer";
    private String username;
    private Collection<? extends GrantedAuthority> authorities;
}
