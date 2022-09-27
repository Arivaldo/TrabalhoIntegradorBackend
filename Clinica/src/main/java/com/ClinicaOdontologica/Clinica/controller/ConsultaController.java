package com.ClinicaOdontologica.Clinica.controller;

import com.ClinicaOdontologica.Clinica.controller.dto.ConsultaDetalhesDto;
import com.ClinicaOdontologica.Clinica.controller.dto.ConsultaForm;
import com.ClinicaOdontologica.Clinica.entity.ConsultaEntity;
import com.ClinicaOdontologica.Clinica.entity.DentistaEntity;
import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import com.ClinicaOdontologica.Clinica.repository.IConsultaRepository;
import com.ClinicaOdontologica.Clinica.repository.IDentistaRepository;
import com.ClinicaOdontologica.Clinica.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/consulta")

public class ConsultaController {

    //Estanciando todos os repositorys para não ter erro
    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    IDentistaRepository dentistaRepository;
    @Autowired
    IConsultaRepository consultaRepository;


    @PostMapping("/{idPaciente}/{idDentista}")
    @Transactional

    public ResponseEntity cadastrarConsulta(@PathVariable("idPaciente") Integer idPaciente,
                                            @PathVariable("idDentista") Integer idDentista,
                                            @RequestBody ConsultaForm consultaForm){

        PacienteEntity paciente = pacienteRepository.findById(idPaciente).orElseThrow(EntityNotFoundException::new);
        DentistaEntity dentista = dentistaRepository.findById(idDentista).orElseThrow(EntityNotFoundException::new);

        ConsultaEntity consulta = consultaForm.toEntity(paciente);

        consultaRepository.save(consulta);

        ConsultaDetalhesDto consultaDetalhesDto = consulta.toconsultaDetalhesDto();

        return ResponseEntity.ok(consulta);

    }}
