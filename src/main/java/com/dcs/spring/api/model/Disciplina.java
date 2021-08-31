package com.dcs.spring.api.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Disciplina implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	
	private String nome;
	private Integer likes;	
	@JoinColumn(name = "disciplina_id")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Nota> notas;
	
	public Disciplina() {
		super();
	}
	
	public Disciplina(Integer id, String nome, int likes, List<Nota> notas) {
		super();
		this.id = id;
		this.nome = nome;
		this.likes = likes;
		this.notas = notas;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public List<Nota> getNotas() {
		return notas;
	}
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	public double notaMediaDaDisciplina() {
		double notaMax= 0;
		for(Nota notas : this.notas) {
			notaMax = notaMax + notas.getNota();
		}
		
		return notaMax/this.notas.size();
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return id == other.id;
	}
	
	
	
}
