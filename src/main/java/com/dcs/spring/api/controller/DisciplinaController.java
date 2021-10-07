package com.dcs.spring.api.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.dcs.spring.api.dto.DisciplinaDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
	public ResponseEntity<DisciplinaDTO> criarDisciplina(@RequestBody Disciplina disciplina) {
		Disciplina disciplinaResponse = disciplinaServices.criar(disciplina);
		DisciplinaDTO disciplinaDTO = this.disciplinaServices.toDisciplinaDTO(disciplinaResponse);
		URI location = ServletUriComponentsBuilder 	 	
	            .fromCurrentRequest()
	            .path("/{id}")
	            .buildAndExpand(disciplinaResponse.getId())
	            .toUri();
		
		return ResponseEntity.created(location).body(disciplinaDTO);
	}
	@GetMapping("/v1/api/disciplinas")
	public ResponseEntity<List<DisciplinaDTO>> buscarDisciplina(){
		return ResponseEntity.ok(this.disciplinaServices.buscar().stream().map(e -> this.disciplinaServices.toDisciplinaDTO(e)).collect(Collectors.toList()));
	}
	
	@GetMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<DisciplinaDTO> buscarDisciplinaPorID(@PathVariable Integer id){
		return ResponseEntity.ok(this.disciplinaServices.toDisciplinaDTO(disciplinaServices.buscarPorId(id)));
			
	}
	@PutMapping("/v1/api/disciplinas/likes/{id}")
	public ResponseEntity<DisciplinaDTO> atualizarLikeDaDisciplina(@PathVariable Integer id){
		DisciplinaDTO disciplinaDTO = this.disciplinaServices.toDisciplinaDTO(disciplinaServices.incrementaLikePorID(id));
		return ResponseEntity.ok().body(disciplinaDTO);
	}

	@PatchMapping("/v1/api/disciplinas/{id}/nome")
	public ResponseEntity<DisciplinaDTO> atualizarNomeDaDisciplina(@PathVariable Integer id, @RequestBody Disciplina disciplinaUpdate){
		Disciplina disciplina = disciplinaServices.atualizaNomeDisciplina(id, disciplinaUpdate);

		return ResponseEntity.ok(this.disciplinaServices.toDisciplinaDTO(disciplina));
	}
	
	@PatchMapping("/v1/api/disciplinas/{id}/nota")
	public ResponseEntity<DisciplinaDTO> atualizarNotaDaDisciplina(@PathVariable Integer id, @RequestBody Disciplina disciplinaUpdate){
		Disciplina disciplina = disciplinaServices.atualizaNotaDisciplina(id, disciplinaUpdate);

		return ResponseEntity.ok().body(this.disciplinaServices.toDisciplinaDTO(disciplina));
	}
	@DeleteMapping("/v1/api/disciplinas/{id}")
	public void removeDisciplinaComId(@PathVariable Integer id) {
		disciplinaServices.deletar(id);
	}

	@GetMapping("/v1/api/disciplinas/ranking")
	public ResponseEntity<List<DisciplinaDTO>> buscarDiciplinasPorMaiorNota(){
		List<DisciplinaDTO> disciplinaDTOS = disciplinaServices.disciplinasComMaioresNotas()
																.stream()
																.map((e) -> this.disciplinaServices.toDisciplinaDTO(e))
																.collect(Collectors.toList());
		return ResponseEntity.ok(disciplinaDTOS);
	}

	@GetMapping("/v1/api/disciplinas/ranking/likes")
	public ResponseEntity<List<DisciplinaDTO>> buscarDiciplinasComMaioresLikes() {
		List<DisciplinaDTO> disciplinaDTOS = disciplinaServices.disciplinasComMaiorLike()
				.stream()
				.map((e) -> this.disciplinaServices.toDisciplinaDTO(e))
				.collect(Collectors.toList());

		return ResponseEntity.ok(disciplinaDTOS);
	}
}
