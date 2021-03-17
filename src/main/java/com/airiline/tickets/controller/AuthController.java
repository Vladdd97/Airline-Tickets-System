package com.airiline.tickets.controller;

import com.airiline.tickets.dto.auth.SignInRequest;
import com.airiline.tickets.dto.auth.SignInResponse;
import com.airiline.tickets.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(AuthController.AUTH_URL)
public class AuthController {

    public static final String AUTH_URL = "/v1/ats/auth";
    public static final String SIGN_IN_URL = "/sign-in";

    private final AuthenticationService authenticationService;

    @PostMapping(SIGN_IN_URL)
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest signInRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(signInRequest.getUsername(), signInRequest.getPassword()));
    }
}
