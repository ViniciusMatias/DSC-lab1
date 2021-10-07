package com.dcs.spring.api.dto;

import com.dcs.spring.api.model.Comentario;
import com.dcs.spring.api.model.Nota;

import java.util.List;

public class DisciplinaDTO {

    private String nome;
    private int like;
    private List<NotaDTO> notas;
    private List<ComentarioDTO> comentarios;

    public DisciplinaDTO(String nome, int like, List<NotaDTO> notas, List<ComentarioDTO> comentarios) {
        this.nome = nome;
        this.like = like;
        this.notas = notas;
        this.comentarios = comentarios;
    }

    public DisciplinaDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public List<NotaDTO> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaDTO> notas) {
        this.notas = notas;
    }

    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }
}
