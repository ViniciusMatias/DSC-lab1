package com.dcs.spring.api.dto;

import com.dcs.spring.api.model.Comentario;

public class ComentarioDTO {

    private String descricao;

    public ComentarioDTO(String descricao) {
        this.descricao = descricao;
    }

    public ComentarioDTO(Comentario comentario) {
        this.descricao = comentario.getDescricao();
    }

    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
