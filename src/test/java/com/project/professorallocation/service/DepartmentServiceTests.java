package com.project.professorallocation.service;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Department;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentServiceTests {
	
	@Autowired
	private DepartmentService service;
	
	@Test
	public void create( ) {
		Department department = new Department ();
		department.setName("Departamento de Tecnologia");	
		
	department = service.create(department);	
	
	}
	@Test
	public void update() {
		Department department = new Department ();
		department.setId(5L);
		department.setName("Departamento de Física");	
		
	department = service.update(department);	
	
	}
	
	@Test
	public void delete() {
		service.deleteById(6L);
	}
	
	@Test
	public void findSpecicDepartment() {
		
		Department dept = service.findById(6L);
		
		System.out.println(dept);
	}

	
	

}
