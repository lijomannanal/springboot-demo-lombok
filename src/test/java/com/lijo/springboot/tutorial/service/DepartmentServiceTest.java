package com.lijo.springboot.tutorial.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.lijo.springboot.tutorial.entity.Department;
import com.lijo.springboot.tutorial.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
	private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    
	@BeforeEach
	void setUp() throws Exception {
		Department department = Department.builder().departmentCode("IT03").departmentId(1L).departmentName("IT").build();
		
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).
		thenReturn(department);
	}

	@Test
	@DisplayName("Get data based on department name")  
	public void validateDepartmentFetchByName() {
		String departmentName = "IT";
		Department found = departmentService.fetchDepartmentByName(departmentName);
		 assertEquals(departmentName, found.getDepartmentName());
	}

}
