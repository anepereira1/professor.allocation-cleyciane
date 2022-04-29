package com.project.professorallocation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.professorallocation.model.Allocation;
import com.project.professorallocation.service.AllocationService;

@RestController
@RequestMapping(path = "/allocations")
public class AllocationController {
	
	private final AllocationService service;
	
	public AllocationController (AllocationService service){
		super();
		this.service = service;
	}
	
	public ResponseEntity<List<Allocation>> findAll(){
		List<Allocation> allItems = service.findAll();
		
		return new ResponseEntity<List<Allocation>>(allItems, HttpStatus.OK);
	}
}
