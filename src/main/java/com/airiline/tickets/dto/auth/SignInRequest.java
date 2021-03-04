package com.airiline.tickets.dto.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SignInRequest {
    @NotBlank
    @ApiModelProperty(value = "username", example = "admin")
    private String username;
    @NotBlank
    @ApiModelProperty(value = "password", example = "admin")
    private String password;
}
