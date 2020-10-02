package com.arasan.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arasan.authservice.dto.UserDataDTO;
import com.arasan.authservice.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/")
@Api(tags = "/")
public class AuthController {
	
	@Autowired
	UserService  userService;
	
	
	@PostMapping("/auth")
	@ApiOperation(value = "${AuthController.authenticate}")
	@ApiResponses(value = {
						@ApiResponse(code = 400, message = "Something went wrong"), 
						@ApiResponse(code = 422, message = "Invalid username/password")
						})
	public String authenticate(@ApiParam("Authenticate User") @RequestBody UserDataDTO user) {
		System.out.println("user ::: "+user.toString());
		return userService.authenticate(user.getUsername(), user.getPassword());
	}
}
