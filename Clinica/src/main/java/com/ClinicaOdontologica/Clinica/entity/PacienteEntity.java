package com.ClinicaOdontologica.Clinica.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private int id;
    private String nome;
    private String sobrenome;
    private String rg;
    private Date dataAlta;

    public PacienteEntity(int id, String nome, String sobrenome, String rg, Date dataAlta) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.dataAlta = dataAlta;
    }

    public PacienteEntity(String nome, String sobrenome, String rg, Date dataAlta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.dataAlta = dataAlta;
    }

    public PacienteEntity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }
}