package com.ClinicaOdontologica.Clinica.entity;


import javax.persistence.*;

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
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
    }

    public EnderecoEntity(String rua, String numero, String bairro, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
    }

    public EnderecoEntity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
