package com.ClinicaOdontologica.Clinica.controller.dto;

import lombok.Getter;

@Getter

public class ConsultaDetalhesDto {
    private int id;
    private String data;
    private String hora;
    private PacienteDto pacienteDto;
    private DentistaDto dentistaDto;

    //Classe para retornar os dados da consulta
    public ConsultaDetalhesDto(int id, String data, String hora, PacienteDto pacienteDto, DentistaDto dentistaDto) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.pacienteDto = pacienteDto;
        this.dentistaDto = dentistaDto;

    }
}
