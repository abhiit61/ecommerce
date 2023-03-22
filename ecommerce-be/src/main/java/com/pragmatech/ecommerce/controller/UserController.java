package com.pragmatech.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragmatech.ecommerce.dto.AuthenticationRequest;
import com.pragmatech.ecommerce.dto.AuthenticationResponse;
import com.pragmatech.ecommerce.dto.ProductResponse;
import com.pragmatech.ecommerce.dto.RegistrationRequest;
import com.pragmatech.ecommerce.dto.UserPrincipal;
import com.pragmatech.ecommerce.dto.UserResponse;
import com.pragmatech.ecommerce.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/auth/registration")
	public ResponseEntity<String> registration(@Valid @RequestBody RegistrationRequest user,
			BindingResult bindingResult) throws Exception {
		return ResponseEntity.ok(userService.registerUser(user));
	}

	@PostMapping("/auth/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) throws Exception {
		return ResponseEntity.ok(userService.login(request));
	}

	@GetMapping("/users/info")
	public ResponseEntity<UserResponse> getUserInfo(@AuthenticationPrincipal UserPrincipal user) throws Exception {
		return ResponseEntity.ok(new UserResponse(userService.getUserInfo(user.getEmail())));
	}

	@PostMapping("/users/cart")
    public ResponseEntity<List<ProductResponse>> getCart(@RequestBody List<Long> productsIds) {
        return ResponseEntity.ok(userService.getCart(productsIds));
    }
	
}
