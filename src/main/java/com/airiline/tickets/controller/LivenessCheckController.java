package com.airiline.tickets.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(LivenessCheckController.LIVENESS_CHECK_URL)
public class LivenessCheckController {
    public static final String LIVENESS_CHECK_URL = "/liveness";

    @GetMapping()
    public ResponseEntity<Map<String, String>> liveCheck() {
        return ResponseEntity.ok(Collections.singletonMap("status", "ALIVE"));
    }
}
