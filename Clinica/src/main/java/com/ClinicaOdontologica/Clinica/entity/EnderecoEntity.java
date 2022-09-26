package com.ClinicaOdontologica.Clinica.entity;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "endereco")

public class EnderecoEntity {
    @Id
    @SequenceGenerator(name = "endereco_sequence", sequenceName = "endereco_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private int id;
    private String rua;
    private String numero;
    private String bairro;
    private String cep;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private PacienteEntity pacienteEntity;

    public EnderecoEntity(int id, String rua, String numero, String bairro, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
    }

    public EnderecoEntity(String rua, String numero, String bairro, String cep, PacienteEntity paciente){}

    public EnderecoEntity toEnderecoEntity() {
        return new EnderecoEntity(
                this.id,
                this.rua,
                this.numero,
                this.bairro,
                this.cep
        );
    }
}
