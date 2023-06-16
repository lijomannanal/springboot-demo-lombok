package com.lijo.springboot.tutorial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lijo.springboot.tutorial.entity.Department;
import com.lijo.springboot.tutorial.error.DepartmentNotFoundException;


@Service
public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long id);

	public Department updateDepartmentById(Long id, Department department);

	public Department fetchDepartmentByName(String name);

}
