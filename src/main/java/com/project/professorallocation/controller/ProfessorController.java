package com.project.professorallocation.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.professorallocation.model.Professor;
import com.project.professorallocation.service.ProfessorService;

@RestController
@RequestMapping(path = "/professors")
public class ProfessorController {
	
	private final ProfessorService service;
	
	public ProfessorController(ProfessorService service) {
		super();
		this.service = service;

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Professor>> findAll() {
		List<Professor> allProfessor = service.findAll();

		return new ResponseEntity<>(allProfessor, HttpStatus.OK);

	}

	@GetMapping(path = "/{professor_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Professor> findById(@PathVariable(name = "professor_id") Long id) {
		Professor item = service.findById(id);

		if (item == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {

			return new ResponseEntity<>(item, HttpStatus.OK);
		}
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Professor> create (@RequestBody Professor professor){
		Professor item = service.create(professor);
		
		return new ResponseEntity<>(item, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/(professor_id)", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseStatus(HttpStatus.OK)
	 public ResponseEntity<Professor> update(@PathVariable(name = "professor_id") Long id, @RequestBody Professor professor) {
	  professor.setId(id);
	  Professor item = service.update(professor);

	  if (item == null) {
	   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  } else {
	   return new ResponseEntity<Professor>(item, HttpStatus.OK);
	  }

	 }

	 @DeleteMapping(path = "/(professor_id)")
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 public ResponseEntity<Void> delete(@PathVariable(name = "professor_id") Long id) {
	  service.deleteById(id);

	  return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	 }
	
	

}
