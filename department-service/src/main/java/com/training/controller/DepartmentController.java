package com.training.controller;

import org.springframework.http.HttpHeaders;

import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.entity.Department;
import com.training.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	private final static org.slf4j.Logger log = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/")
	public ResponseEntity<Department> addDepartment(@RequestBody Department theDepartment) {
		departmentService.addDepartment(theDepartment);
		 HttpHeaders headers =  new HttpHeaders();
		 headers.add("Reader", "StudentController");
		 log.info("Department has been created : " + theDepartment);
		return new ResponseEntity<>(theDepartment,HttpStatus.CREATED);		
	}
	
	@GetMapping("/{departmentId}")
	public Optional<Department> findDepartmentById(@PathVariable Integer departmentId){
		log.info("Department has been printed:"+departmentId);
		return departmentService.findDepartmentById(departmentId);
		
	}
}
