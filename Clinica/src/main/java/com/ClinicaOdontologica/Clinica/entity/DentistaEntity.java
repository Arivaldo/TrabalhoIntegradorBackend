package com.ClinicaOdontologica.Clinica.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DentistaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nome;
    private String sobrenome;
    private String matriculaCad;

    public DentistaEntity(int id, String nome, String sobrenome, String matriculaCad) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matriculaCad = matriculaCad;
    }

    public DentistaEntity(String nome, String sobrenome, String matriculaCad) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matriculaCad = matriculaCad;
    }

    public DentistaEntity(){}

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

    public String getMatriculaCad() {
        return matriculaCad;
    }

    public void setMatriculaCad(String matriculaCad) {
        this.matriculaCad = matriculaCad;
    }
}
