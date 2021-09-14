package com.dcs.spring.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dcs.spring.api.model.Disciplina;
import com.dcs.spring.api.model.Nota;
import com.dcs.spring.api.repository.DisciplinaRepository;

@SpringBootApplication
public class DscLab1Application {

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DscLab1Application.class, args);
	}


}
