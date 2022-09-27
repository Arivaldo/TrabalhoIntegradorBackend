package com.ClinicaOdontologica.Clinica.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DentistaDto {
    private int id;
    private String nome;
    private String sobrenome;
    private String matriculaCad;

    public DentistaDto(int id, String nome, String sobrenome, String matriculaCad) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matriculaCad = matriculaCad;
    }
}
