package com.ClinicaOdontologica.Clinica.controller.dto;

import com.ClinicaOdontologica.Clinica.entity.EnderecoEntity;
import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class EnderecoForm {
    private String rua;
    private String numero;
    private String bairro;
    private String cep;

    public EnderecoForm(String rua, String numero, String bairro, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
    }

    public EnderecoEntity toEntity(PacienteEntity paciente) {
        return new EnderecoEntity(
                this.rua,
                this.numero,
                this.bairro,
                this.cep,
                paciente);
    }
}
