package com.ClinicaOdontologica.Clinica.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Dentista")

public class DentistaEntity {
    @Id
    @SequenceGenerator(name = "dentista_sequence", sequenceName = "dentista_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private int id;
    private String nome;
    private String sobrenome;
    private String matriculaCad;


@OneToMany(mappedBy = "dentistaEntity", fetch = FetchType.LAZY)
private Set<PacienteEntity> consultas = new HashSet<PacienteEntity>();

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

    public DentistaEntity(){
       }

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
