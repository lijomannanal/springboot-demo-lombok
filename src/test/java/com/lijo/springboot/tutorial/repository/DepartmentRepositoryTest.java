package com.lijo.springboot.tutorial.repository;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.lijo.springboot.tutorial.entity.Department;

@DataJpaTest
class DepartmentRepositoryTest  {
	
 @Autowired	
 private DepartmentRepository departmentRepository;
 
 @Autowired	
 private EntityManager entity;

	@BeforeEach
	void setUp() throws Exception {
		
		Department department = Department.builder().departmentName("Information Technology").departmentCode("IT06").build();
		entity.persist(department);
	}

	@Test
	@DisplayName("Get department by id")
	void test() {
		Department departmentDB = departmentRepository.findById(1L).get();
		assertEquals("Information Technology", departmentDB.getDepartmentName());
	}

}
