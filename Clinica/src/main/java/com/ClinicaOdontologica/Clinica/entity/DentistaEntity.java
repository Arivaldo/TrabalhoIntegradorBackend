package com.ClinicaOdontologica.Clinica.entity;


import com.ClinicaOdontologica.Clinica.controller.dto.DentistaDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "dentista")

public class DentistaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "dentista_sequence")
    @Column(name="id")
    @SequenceGenerator(name = "dentista_sequence", sequenceName = "dentista_sequence")
    private int id;
    @Column(name="nome")
    private String nome;
    @Column(name="sobrenome")
    private String sobrenome;
    @Column(name="matricula")
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


    public DentistaDto toDentistaDto() {
        return new DentistaDto(
                this.id,
                this.nome,
                this.sobrenome,
                this.matriculaCad
        );
    }
}
