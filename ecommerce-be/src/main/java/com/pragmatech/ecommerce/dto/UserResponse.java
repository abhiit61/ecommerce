package com.pragmatech.ecommerce.dto;

import com.pragmatech.ecommerce.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse extends BaseUserResponse {
    public UserResponse(User user) {
		this.address = user.getAddress();
		this.city = user.getCity();
		this.lastName = user.getLastName();
		this.phoneNumber = user.getPhoneNumber();
		setFirstName(user.getFirstName());
		setEmail(user.getEmail());
		setId(user.getId());
		setRoles(user.getRoles());
	}
	private String lastName;
    private String city;
    private String address;
    private String phoneNumber;
}
