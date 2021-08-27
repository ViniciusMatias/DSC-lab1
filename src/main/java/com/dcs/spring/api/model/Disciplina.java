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
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String nome;
	private Integer likes;	
	@JoinColumn(name = "disciplina_id")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Nota> notas;
	
	public Disciplina() {
		super();
	}
	
	public Disciplina(int id, String nome, int likes, List<Nota> notas) {
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
