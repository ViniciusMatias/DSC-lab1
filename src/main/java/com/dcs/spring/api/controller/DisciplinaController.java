package com.dcs.spring.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dcs.spring.api.model.Disciplina;
import com.dcs.spring.api.services.DisciplinaServices;
import com.dcs.spring.api.services.exception.EntityNotFoundEx;

@Controller
@RestController
public class DisciplinaController {
	
	@Autowired
	private DisciplinaServices disciplinaServices;
	
	@PostMapping("/v1/api/disciplinas")
	public ResponseEntity<Disciplina> criarDisciplina(@RequestBody Disciplina disciplina) {
		Disciplina disciplinaResponse = disciplinaServices.criar(disciplina);
		
		URI location = ServletUriComponentsBuilder 	 	
	            .fromCurrentRequest()
	            .path("/{id}")
	            .buildAndExpand(disciplinaResponse.getId())
	            .toUri();
		
		return ResponseEntity.created(location).build();
	}
	@GetMapping("/v1/api/disciplinas")
	public ResponseEntity<List<Disciplina>> buscarDisciplina(){
		return ResponseEntity.ok(disciplinaServices.buscar());
	}
	
	@GetMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> buscarDisciplinaPorID(@PathVariable Integer id){
		return ResponseEntity.ok(disciplinaServices.buscarPorId(id));
			
	}
	@PatchMapping("/v1/api/disciplinas/{id}/nome")
	public ResponseEntity<Disciplina> atualizarNomeDaDisciplina(@PathVariable Integer id, @RequestBody Disciplina disciplinaUpdate){
		
		
		return ResponseEntity.ok(disciplinaServices.atualizaNomeDisciplina(id, disciplinaUpdate));
	}
	
	@PatchMapping("/v1/api/disciplinas/{id}/nota")
	public ResponseEntity<Disciplina> atualizarNotaDaDisciplina(@PathVariable Integer id, @RequestBody Disciplina disciplinaUpdate){
		
		
		return ResponseEntity.ok(disciplinaServices.atualizaNotaDisciplina(id, disciplinaUpdate));
	}
	@DeleteMapping("/v1/api/disciplinas/{id}")
	public void removeDisciplinaComId(@PathVariable Integer id) {
		disciplinaServices.deletar(id);
	}
	@GetMapping("/v1/api/disciplinas/ranking")
	public ResponseEntity<List<Disciplina>> buscarDiciplinasPorMaiorNota(){
		return ResponseEntity.ok(disciplinaServices.disciplinasComMaioresNotas());
	}
}
