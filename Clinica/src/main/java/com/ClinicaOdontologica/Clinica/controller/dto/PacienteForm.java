package com.ClinicaOdontologica.Clinica.controller.dto;

import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor

public class PacienteForm {

    @NotNull
    private String nome;
    private String sobrenome;
    private String dataAlta;
    private String username;
    private String password;


    public PacienteForm(String nome, String sobrenome, String dataAlta, String username, String password) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataAlta = dataAlta;
        this.username = username;
        this.password = password;
    }

    public PacienteEntity toEntity() {
        return new PacienteEntity(
                this.nome,
                this.sobrenome,
                this.dataAlta,
                this.username,
                this.password);
    }
}

