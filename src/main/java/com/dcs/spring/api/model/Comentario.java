package com.dcs.spring.api.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
//    @ManyToOne
//    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    public Comentario(Integer id, String descricao, Disciplina disciplina) {
        this.id = id;
        this.descricao = descricao;
        this.disciplina = disciplina;
    }

    public Comentario() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comentario that = (Comentario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
