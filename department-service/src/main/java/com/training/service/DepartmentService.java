package com.training.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.entity.Department;
import com.training.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public void addDepartment(Department theDepartment) {
		departmentRepository.save(theDepartment);
		System.out.println("\n New Department has been added");
	}
	
	public Optional<Department> findDepartmentById(Integer departmentId) {
		return departmentRepository.findById(departmentId);
		
		
	}
}
