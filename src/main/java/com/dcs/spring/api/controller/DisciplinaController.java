package com.dcs.spring.api.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dcs.spring.api.model.Disciplina;
import com.dcs.spring.api.services.DisciplinaServices;

@Controller
@RestController("/v1/api/disciplinas")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaServices disciplinaServices;
	
	@PostMapping
	public ResponseEntity<Disciplina> criarDisciplina(@RequestBody Disciplina disciplina) {
		Disciplina disciplinaResponse = disciplinaServices.criar(disciplina);
		
		URI location = ServletUriComponentsBuilder
	            .fromCurrentRequest()
	            .path("/{id}")
	            .buildAndExpand(disciplinaResponse.getId())
	            .toUri();
		return ResponseEntity.created(location).build();
	}
}
