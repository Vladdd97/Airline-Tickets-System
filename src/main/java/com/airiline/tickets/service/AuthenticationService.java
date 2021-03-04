package com.airiline.tickets.service;

import com.airiline.tickets.dto.auth.SignInResponse;

public interface AuthenticationService {
    SignInResponse authenticate(String username, String password);
}
