package com.te.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.userservice.dto.UserDto;
import com.te.userservice.entities.User;
import com.te.userservice.responce.Responce;
import com.te.userservice.userservice.Userservice;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private Userservice service;

	@PostMapping("/addUser")
	public ResponseEntity<Responce> addUser(@RequestBody UserDto dto) {
		User user = service.saveUser(dto);
		return new ResponseEntity<Responce>(new Responce(false, "User Added Succesfully", user), HttpStatus.OK);
	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<Responce> getUser(@PathVariable int id) {
		User user = service.getUser(id);
		return new ResponseEntity<Responce>(new Responce(false, "Getting User Details Succesfully", user),
				HttpStatus.OK);
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<Responce> getAllUser() {
		List<User> user = service.getAllUser();
		return new ResponseEntity<Responce>(new Responce(false, "Getting All User Details", user), HttpStatus.OK);
	}
}
