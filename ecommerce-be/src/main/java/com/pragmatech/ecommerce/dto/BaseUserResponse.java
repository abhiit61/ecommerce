package com.pragmatech.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import com.pragmatech.ecommerce.enums.Role;


@Getter
@Setter
public class BaseUserResponse {
    private Long id;
    private String email;
    private String firstName;
    private Set<Role> roles;
}
