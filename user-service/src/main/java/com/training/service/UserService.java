package com.training.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.VO.Department;
import com.training.VO.ResponseTemplateVO;
import com.training.entity.User;
import com.training.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;

	public void saveUser(User theUser) {
		userRepository.save(theUser);
	}

	public ResponseTemplateVO findDepartmentByUserId(Integer userId) {
		ResponseTemplateVO vo= new ResponseTemplateVO();
		User theUser= userRepository.findDepartmentByUserId(userId);
		Department department= restTemplate.getForObject("http://localhost:8081/departments/"+theUser.getDepartmentId()
							, Department.class);
		vo.setDepartment(department);
		vo.setUser(theUser);
		return vo;
	}


}
