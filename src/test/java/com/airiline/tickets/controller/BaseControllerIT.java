package com.airiline.tickets.controller;

import lombok.val;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.nio.file.Files;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public abstract class BaseControllerIT {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private ResourceLoader resourceLoader;

    protected String readMockRequestFromFile(String fileName) throws IOException {
        return readFile("classpath:/mock-request/" + fileName);
    }

    protected String readMockResponseFromFile(String fileName) throws IOException {
        return readFile("classpath:/expected-response/" + fileName);
    }

    private String readFile(String path) throws IOException {
        val resource = resourceLoader.getResource(path);
        return new String(Files.readAllBytes(resource.getFile().toPath()));
    }

}
