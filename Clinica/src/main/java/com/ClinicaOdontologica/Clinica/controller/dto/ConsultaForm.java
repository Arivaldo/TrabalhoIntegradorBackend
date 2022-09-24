package com.ClinicaOdontologica.Clinica.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsultaForm {

    @JsonProperty("consulta")
    private String consulta;

    public String getConsulta() {
        return consulta;
    }

    public ConsultaForm() {
    }

    public ConsultaForm(String consulta) {
        this.consulta = consulta;
    }
}
