package com.dcs.spring.api.services;

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

}
