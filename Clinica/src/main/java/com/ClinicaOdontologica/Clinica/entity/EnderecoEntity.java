package com.ClinicaOdontologica.Clinica.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "endereco")
@NoArgsConstructor

public class EnderecoEntity {
    @Id
    @SequenceGenerator(name = "endereco_sequence", sequenceName = "endereco_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name="id")
    private int id;
    @Column(name="rua")
    private String rua;
    @Column(name="numero")
    private String numero;
    @Column(name="bairro")
    private String bairro;
    @Column(name="cidade")
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
