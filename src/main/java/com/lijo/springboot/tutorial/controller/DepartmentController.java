package com.lijo.springboot.tutorial.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lijo.springboot.tutorial.entity.Department;
import com.lijo.springboot.tutorial.error.DepartmentNotFoundException;
import com.lijo.springboot.tutorial.service.DepartmentService;


@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department ) {
		LOGGER.info("saveDepartment api got called in DepartmentController");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList() {
		LOGGER.info("fetchDepartmentList api got called in DepartmentController");
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable Long id) throws DepartmentNotFoundException {
		return departmentService.fetchDepartmentById(id);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable Long id) {
		departmentService.deleteDepartmentById(id);
		return "Department deleted successfully";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartmentById(@PathVariable Long id, @RequestBody Department department) {
		return departmentService.updateDepartmentById(id, department); 
	}
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable String name) {
		return departmentService.fetchDepartmentByName(name); 
	}


}
