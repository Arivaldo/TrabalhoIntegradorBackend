package com.ClinicaOdontologica.Clinica.entity;

import com.ClinicaOdontologica.Clinica.controller.dto.PacienteDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "paciente")
@NoArgsConstructor

public class PacienteEntity {
    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name="id")
    private int id;
    @Column(name="nome")
    private String nome;
    @Column(name="sobrenome")
    private String sobrenome;
    @Column(name="rg")
    private String rg;
    @Column(name="dataAlta")
    private String dataAlta;
    @Column(name="Username")
    private String username;
    @Column(name="Password")
    private String password;


    @ManyToOne
    private DentistaEntity dentistaEntity;

    @OneToOne
    private EnderecoEntity enderecoEntity;

    @OneToOne
    private ConsultaEntity consultaEntity;

//    public void agendarConsulta(ConsultaEntity consultaEntity){
//        this.consultaEntityList.add(consultaEntity);
//}
////Criando a classe agendar consulta

    public PacienteEntity(String nome, String sobrenome, String dataAlta, String username, String password) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataAlta = dataAlta;
        this.username = username;
        this.password = password;
    }
    public PacienteEntity(String nome, String sobrenome, String dataAlta, String username){}

    //Criando o método dto para ocultar a senha
    public PacienteDto toPacienteDto(){
        return new PacienteDto(
                this.id,
                this.nome,
                this.sobrenome,
                this.rg,
                this.dataAlta,
                this.username);
    }
}