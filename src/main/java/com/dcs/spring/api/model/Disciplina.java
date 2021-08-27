package com.dcs.spring.api.model;

import java.util.List;
import java.util.Objects;

public class Disciplina {

	private int id;
	private String nome;
	private int likes;
	private List<Double> notas;
	
	public Disciplina() {
		super();
	}
	
	public Disciplina(int id, String nome, int likes, List<Double> notas) {
		super();
		this.id = id;
		this.nome = nome;
		this.likes = likes;
		this.notas = notas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public List<Double> getNotas() {
		return notas;
	}
	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
