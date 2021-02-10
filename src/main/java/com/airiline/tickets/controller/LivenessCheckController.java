package com.airiline.tickets.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class LivenessCheckController {

    @GetMapping("/liveness")
    public ResponseEntity<Map<String, String>> liveCheck() {
        return ResponseEntity.ok(Collections.singletonMap("status", "ALIVE"));
    }
}
