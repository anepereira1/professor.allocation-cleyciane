package com.project.professorallocation.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Professor;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorServiceTests {
	
	@Autowired
	private ProfessorService service;
	
	@Test
	public void create() {
		Professor professor = new Professor();
		professor.setName("Mag Ferraz");
		professor.setDepartmentId(3L);
		professor.setCpf("09123456788");
		
		professor = service.create(professor);

	}

	@Test
	public void update() {

		Professor professor = new Professor();
		professor.setId(1L);
		professor.setName("Joao");
		professor.setCpf("09123456797");
		professor.setDepartmentId(2L);

		professor = service.update(professor);

	}

	@Test
	public void findSpecicProfessor() {

		Professor dept = service.findById(2L);

		System.out.println(dept);

	}
}
