package br.com.hazforge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hazforge.data.vo.v1.PersonVO;
import br.com.hazforge.data.vo.v2.PersonVOV2;
import br.com.hazforge.services.PersonServices;
import br.com.hazforge.util.MediaType;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	
	@Autowired
	private PersonServices service;
//	private PersonServices service = new PersonServices();
	
	@GetMapping(value = "/{id}",
			produces = { MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML , MediaType.APPLICATION_YML })
	public PersonVO findById(
			@PathVariable Long id) {
		return service.findById(id);
	}
	
	@GetMapping(
			produces = { MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML , MediaType.APPLICATION_YML })
	public List<PersonVO> findAll() throws Exception  {
		return service.findAll();
	}
	
	
	@PostMapping(
			produces = { MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML , MediaType.APPLICATION_YML },
			consumes = { MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML , MediaType.APPLICATION_YML })
	public PersonVO create(@RequestBody(required = false) PersonVO person) throws Exception  {
		return service.create(person);
	}
	
	@PostMapping(
			value = "/v2",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE )
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) throws Exception  {
		return service.createV2(person);
	}
	
	@PutMapping(
			produces = { MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML , MediaType.APPLICATION_YML },
			consumes = { MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML , MediaType.APPLICATION_YML })
	public PersonVO update(@RequestBody PersonVO person) throws Exception  {
		return service.update(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(
			@PathVariable Long id) throws Exception  {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
