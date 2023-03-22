package com.pragmatech.ecommerce.dto;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private UserResponse user;
    private String token;
}
