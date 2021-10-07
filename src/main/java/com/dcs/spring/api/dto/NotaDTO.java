package com.dcs.spring.api.dto;

import com.dcs.spring.api.model.Nota;

public class NotaDTO {

    private Double nota;

    public NotaDTO(Double nota) {
        this.nota = nota;
    }

    public NotaDTO(Nota nota){
        this.nota = nota.getNota();
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
