package com.payment.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.model.User;
import com.payment.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/me")
	public String getCurrentUser(Authentication authentication) {
		return "Hello, " + authentication.getName();
	}

	@PostMapping
	public User create(@RequestBody User user) {
		return userService.createUser(user);
	}

	@GetMapping
	public List<User> getAll() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PutMapping("/{id}")
	public User update(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}
