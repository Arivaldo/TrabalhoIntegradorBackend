package com.ClinicaOdontologica.Clinica.controller.dto;

import com.ClinicaOdontologica.Clinica.entity.ConsultaEntity;
import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import lombok.Getter;

@Getter

public class ConsultaForm {
    private String data;
    private String hora;


    public ConsultaForm(String data, String hora) {
        this.data = data;
        this.hora = hora;
    }

    public ConsultaEntity toEntity(PacienteEntity paciente) {
        return new ConsultaEntity(
                this.data,
                this.hora,
                paciente);
    }
}
