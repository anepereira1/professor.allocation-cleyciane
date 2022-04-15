package com.project.professorallocation.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentRepositoryTests {
	
	@Autowired
	private DepartmentRepository repository;
	
	
	@Test
	public void findAll() {
		List<Department> items = repository.findAll();
		
		System.out.println("Qtd elements retornados: " + items.size());
	
		for(Department item : items) {
			System.out.println(item);
		}
	
	}
	
	@Test
	public void create( ) {
		Department departmentBeingCreated = new Department ();
		departmentBeingCreated.setName("Departamento de Estatísticas");	
		
	departmentBeingCreated = repository.save(departmentBeingCreated);	

	System.out.println(departmentBeingCreated);
	
	}
	@Test
	public void update() {
		Department departmentBeingCreated = new Department ();
		departmentBeingCreated.setId(5L);
		departmentBeingCreated.setName("Departamento de Fiosioterapia");	
		
	departmentBeingCreated = repository.save(departmentBeingCreated);	
	System.out.println(departmentBeingCreated);
	
	}
	
	@Test
	public void delete() {
		repository.deleteById(6L);
	}
	
	@Test
	public void findSpecicDepartment() {
		
		Department dept = repository.findById(6L).orElse(null);
		
		System.out.println(dept);
	}

}
