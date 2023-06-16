package com.lijo.springboot.tutorial.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.lijo.springboot.tutorial.entity.Department;
import com.lijo.springboot.tutorial.service.DepartmentService;

@WebMvcTest
class DepartmentControllerTest {
	@Autowired
	private DepartmentController departmentController;
	
	@MockBean
	private DepartmentService departmentService;
	
	
	@Autowired
	private MockMvc mockMvc;
	
	private Department department;

	@BeforeEach
	void setUp() throws Exception {
		
		department = Department.builder().departmentId(1L).departmentName("IT").departmentCode("IT06").build();
	}

	@Test
	@DisplayName("save department")
	void test() throws Exception {
		Department inputDepartment = Department.builder().departmentId(1L).departmentName("IT").departmentCode("IT06").build();
		Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON).content("{\r\n"
				+ "	\"departmentName\": \"IT\",\r\n"
				+ "	\"departmentCode\": \"IT06\"\r\n"
				+ "}")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	@DisplayName("fetch department by id")
	void test2() throws Exception {;
		Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/departments/1").contentType(MediaType.APPLICATION_JSON)).
		andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
	}

}
