package com.ClinicaOdontologica.Clinica.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Paciente {

    private int id;
    private String nome;
    private String sobrenome;
    private String rg;
    LocalDate alta;

}