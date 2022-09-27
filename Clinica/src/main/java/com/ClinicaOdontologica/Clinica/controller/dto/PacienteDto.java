package com.ClinicaOdontologica.Clinica.controller.dto;

import lombok.Getter;

@Getter
public class PacienteDto {

        private int id;
        private String nome;
        private String sobrenome;
        private String rg;
        private String dataAlta;
        private String username;

        public PacienteDto(int id, String nome, String sobrenome, String rg, String dataAlta, String username) {
            this.id = id;
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.rg = rg;
            this.dataAlta = dataAlta;
            this.username = username;
        }
}
