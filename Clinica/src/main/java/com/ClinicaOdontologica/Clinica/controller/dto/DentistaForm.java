package com.ClinicaOdontologica.Clinica.controller.dto;

import com.ClinicaOdontologica.Clinica.entity.DentistaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class DentistaForm  {
    private String nome;
    private String sobrenome;
    private String matriculaCad;

    public DentistaForm(String nome, String sobrenome, String matriculaCad) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matriculaCad = matriculaCad;
    }

    public DentistaEntity toEntity() {
        return new DentistaEntity(
                this.nome,
                this.sobrenome,
                this.matriculaCad
        );
    }
}
