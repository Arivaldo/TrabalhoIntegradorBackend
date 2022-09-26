package com.ClinicaOdontologica.Clinica.entity;


import com.ClinicaOdontologica.Clinica.controller.dto.DentistaDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private PacienteEntity paciente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consulta_id")
    private ConsultaEntity consulta;


    public DentistaEntity(String nome, String sobrenome, String matriculaCad, PacienteEntity paciente) {
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
