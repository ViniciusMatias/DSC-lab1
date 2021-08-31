package com.dcs.spring.api.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.spring.api.model.Disciplina;
import com.dcs.spring.api.repository.DisciplinaRepository;

@Service
public class DisciplinaServices {

	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	
	
	public Disciplina criar(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}



	public List<Disciplina> buscar() {
		return disciplinaRepository.findAll();
		
	}



	public Disciplina buscarPorId(Integer id) {
		return disciplinaRepository.findById(id).get();
	}



	public Disciplina atualizaNomeDisciplina(Integer id, Disciplina disciplinaUpdate) {
		Disciplina disciplina = buscarPorId(id);
		BeanUtils.copyProperties(disciplinaUpdate, disciplina, "id", "likes", "notas");
		return(disciplinaRepository.save(disciplina));
	}



	public Disciplina atualizaNotaDisciplina(Integer id, Disciplina disciplinaUpdate) {
		Disciplina disciplina = buscarPorId(id);
		BeanUtils.copyProperties(disciplinaUpdate, disciplina, "id", "likes", "nome");
		
		return(disciplinaRepository.save(disciplina));
		
	}



	public void deletar(Integer id) {
		disciplinaRepository.deleteById(id);
	}
	
	public List<Disciplina> disciplinasComMaioresNotas(){
		List<Disciplina> lista = disciplinaRepository.findAll();
		
		Collections.sort(lista, Comparator.comparing(Disciplina::notaMediaDaDisciplina).reversed());
		
		return lista;
	}

}
