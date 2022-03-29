package com.training.controller;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.VO.ResponseTemplateVO;
import com.training.entity.User;
import com.training.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	static org.slf4j.Logger log= LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/")
	public ResponseEntity<User> saveUser(@RequestBody User theUser) {
		userService.saveUser(theUser);
		HttpHeaders headers =  new HttpHeaders();
		 headers.add("Reader", "StudentController");
		 log.info("User has been created : " + theUser);
		return new ResponseEntity<>(theUser,HttpStatus.CREATED);
	}
	@GetMapping("/findDepartmentByUserId/{userId}")
	public ResponseTemplateVO findDepartmentByUserId(@PathVariable Integer userId) {
		return userService.findDepartmentByUserId(userId);
	}
	
}	
