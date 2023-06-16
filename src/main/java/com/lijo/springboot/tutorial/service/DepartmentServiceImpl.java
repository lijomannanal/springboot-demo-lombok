package com.lijo.springboot.tutorial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijo.springboot.tutorial.entity.Department;
import com.lijo.springboot.tutorial.error.DepartmentNotFoundException;
import com.lijo.springboot.tutorial.repository.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
    private DepartmentRepository departmentRepositiory;
	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepositiory.save(department);
	}
	@Override
	public List<Department> fetchDepartmentList() {
		// TODO Auto-generated method stub
		return departmentRepositiory.findAll();
	}
	@Override
	public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Department> department =  departmentRepositiory.findById(id);
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department does not exist");
			
		} else {
			return department.get();
		}
	}
	@Override
	public void deleteDepartmentById(Long id) {
		// TODO Auto-generated method stub
		departmentRepositiory.deleteById(id);	
	}
	@Override
	public Department updateDepartmentById(Long id, Department department) {
		Department dbDepartment =  departmentRepositiory.findById(id).get();
			if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
				dbDepartment.setDepartmentName(department.getDepartmentName());
			}
			if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
				dbDepartment.setDepartmentCode(department.getDepartmentCode());
			}
			
			return departmentRepositiory.save(dbDepartment);

	}
	@Override
	public Department fetchDepartmentByName(String name) {
		// TODO Auto-generated method stub
		return departmentRepositiory.findByDepartmentNameIgnoreCase(name);
	}

}
