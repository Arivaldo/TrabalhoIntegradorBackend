package com.ClinicaOdontologica.Clinica.entity;

import com.ClinicaOdontologica.Clinica.controller.dto.ConsultaDetalhesDto;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "consulta")

public class ConsultaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consulta_sequence")
    @Column(name="id")
    @SequenceGenerator(name = "consulta_sequence", sequenceName = "consulta_sequence")
    private int id;
    @Column(name="data")
    private String data;
    @Column(name="hora")
    private String hora;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "paciente_id")
    private PacienteEntity pacienteEntity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "dentista_id")
    private DentistaEntity dentistaEntity;

    public ConsultaEntity(int id, String data, String hora, PacienteEntity pacienteEntity, DentistaEntity dentistaEntity) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.pacienteEntity = pacienteEntity;
        this.dentistaEntity = dentistaEntity;
    }

    public ConsultaEntity(String data, String hora, PacienteEntity pacienteEntity, DentistaEntity dentistaEntity) {
        this.data = data;
        this.hora = hora;
        this.pacienteEntity = pacienteEntity;
        this.dentistaEntity = dentistaEntity;
    }

    public ConsultaEntity(){
    }

public ConsultaDetalhesDto toconsultaDetalhesDto(){
        return new ConsultaDetalhesDto(
                this.id,
                this.data,
                this.hora,
                this.pacienteEntity.toPacienteDto(),
                this.dentistaEntity.toDentistaDto());
    }
}

