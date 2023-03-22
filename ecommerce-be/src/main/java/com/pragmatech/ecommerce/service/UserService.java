package com.pragmatech.ecommerce.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.pragmatech.ecommerce.config.JwtUtils;
import com.pragmatech.ecommerce.dto.AuthenticationRequest;
import com.pragmatech.ecommerce.dto.AuthenticationResponse;
import com.pragmatech.ecommerce.dto.ProductResponse;
import com.pragmatech.ecommerce.dto.RegistrationRequest;
import com.pragmatech.ecommerce.dto.UserResponse;
import com.pragmatech.ecommerce.entity.Product;
import com.pragmatech.ecommerce.entity.User;
import com.pragmatech.ecommerce.enums.Role;
import com.pragmatech.ecommerce.repository.ProductRepository;
import com.pragmatech.ecommerce.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ProductRepository productRepository;

	public String registerUser(RegistrationRequest registrationRequest) throws Exception {
		User user = new User(registrationRequest);

		if (user.getPassword() != null && !user.getPassword().equals(registrationRequest.getPassword2())) {
			throw new Exception("Passwords do not match.");
		}

		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
			throw new Exception("Email is already used.");
		}
		user.setActive(true);
		user.setRoles(Collections.singleton(Role.USER));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "User successfully registered.";
	}

	public AuthenticationResponse login(AuthenticationRequest request) throws Exception {
		Map<String, Object> response = new HashMap<>();
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
			User user = userRepository.findByEmail(request.getEmail())
					.orElseThrow(() -> new Exception("Email not found."));
			String token = jwtUtils.generateJwtToken(request.getEmail(), request.getEmail());
			response.put("user", user);
			response.put("token", token);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Incorrect password or email");
		}

		AuthenticationResponse resp = new AuthenticationResponse();
		resp.setUser(new UserResponse((User) response.get("user")));
		resp.setToken((String) response.get("token"));
		return resp;
	}
	
    public User getUserInfo(String email) throws Exception {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Email not found."));
    }

    public List<ProductResponse> getCart(List<Long> productsIds) {
    	List<Product> products = productRepository.findByIdIn(productsIds);
    	List<ProductResponse> respList = products.stream().map(p -> new ProductResponse(p)).collect(Collectors.toList());
        return respList;
    }

}
