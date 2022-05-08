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

import com.project.professorallocation.model.Allocation;

import com.project.professorallocation.service.AllocationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/allocations")
public class AllocationController {

	private final AllocationService service;

	public AllocationController(AllocationService service) {
		super();
		this.service = service;
	}

	@ApiOperation(value = "Find all allocations")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Allocation>> findAll() {
		List<Allocation> allItems = service.findAll();
		return new ResponseEntity<List<Allocation>>(allItems, HttpStatus.OK);
	}

	@ApiOperation(value = "Find all an allocations by id")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = " Allocation not found") })

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Allocation> findById(@PathVariable(name = "id") Long id) {
		Allocation allocation = service.findById(id);
		if (allocation == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(allocation, HttpStatus.OK);
		}
	}

	@GetMapping(path = "/professor/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Allocation>> findByProfessorId(@PathVariable(name = "id") Long id) {
		List<Allocation> allItems = service.findByProfessorId(id);
		return new ResponseEntity<List<Allocation>>(allItems, HttpStatus.OK);

	}

	@GetMapping(path = "/course/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Allocation>> findByCourseId(@PathVariable(name = "id") Long id) {
		List<Allocation> allItems = service.findByCourseId(id);
		return new ResponseEntity<List<Allocation>>(allItems, HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Allocation> create(@RequestBody Allocation allocation) {
		try {
			Allocation item = service.create(allocation);
			return new ResponseEntity<>(item, HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping(path = "/{alloc_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Allocation> update(@PathVariable(name = "alloc_id") Long id, @RequestBody Allocation alloc) {
		try {
			alloc.setId(id);
			Allocation item = service.update(alloc);
			if (item == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(item, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(path = "/(allocation_id)")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> delete(@PathVariable(name = "allocation_id") Long id) {
		service.deleteById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

// curl -v --request POST --header "Content-Type: application/json" --header "Accept: application/json" --data-raw "{\"dayOfWeek\": \"MONDAY\", \"startHour\": \"19:00-0300\", \"endHour\": \"21:00-0300\", \"professorId\": \"3\", \"courseID\": \"4\"}" "http://localhost:8080/allocations"

// curl -v --request POST --header "Content-Type: application/json" --header "Accept: application/json" --data-raw "{\"dayOfWeek\": \"MONDAY\", \"startHour\": \"19:00-0300\", \"endHour\": \"21:00-0300\", \"professorId\": \"2\", \"courseID\": \"3\"}" "http://localhost:8080/allocations"

