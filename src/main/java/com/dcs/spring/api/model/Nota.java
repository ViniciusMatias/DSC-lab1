package com.dcs.spring.api.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Nota implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double nota;
//	@ManyToOne
//	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;



	public Nota(Integer id, Double nota, Disciplina disciplina) {

		this.id = id;
		this.nota = nota;
		this.disciplina = disciplina;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Nota() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	
	
	
}
