package com.ClinicaOdontologica.Clinica.controller.dto;

import com.ClinicaOdontologica.Clinica.entity.DentistaEntity;
import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class ConsultaDetalhesDto {
    private int id;
    private String data;
    private String hora;
    private PacienteDto pacienteDto;
    private DentistaDto dentistaDto;

    //Classe para retornar os dados da consulta
    public ConsultaDetalhesDto(String data, String hora, PacienteEntity pacienteEntity, DentistaEntity dentistaEntity) {

        this.data = data;
        this.hora = hora;
        this.pacienteDto = pacienteDto;
        this.dentistaDto = dentistaDto;

    }


}
