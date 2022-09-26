package com.ClinicaOdontologica.Clinica.controller;

import com.ClinicaOdontologica.Clinica.controller.dto.EnderecoForm;
import com.ClinicaOdontologica.Clinica.entity.EnderecoEntity;
import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import com.ClinicaOdontologica.Clinica.repository.IEnderecoRepository;
import com.ClinicaOdontologica.Clinica.repository.IPacienteRepository;
import com.ClinicaOdontologica.Clinica.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.sql.SQLException;

@RestController
@RequestMapping("/endereco")



public class EnderecoController {

    @Autowired
    EnderecoService service;

    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    IEnderecoRepository enderecoRepository;

    EnderecoEntity endereco;


    @PostMapping("/{idPaciente}")
    @Transactional

    public ResponseEntity cadastrarEndereco(@PathVariable("idPaciente") Integer idPaciente,
                                            @RequestBody EnderecoForm enderecoForm) {


        PacienteEntity paciente = pacienteRepository.findById(idPaciente).orElseThrow(EntityNotFoundException::new);
        EnderecoEntity endereco = enderecoForm.toEntity(paciente);

        enderecoRepository.save(endereco);

        return ResponseEntity.ok(endereco);
    }

    @PatchMapping("/alterar/{idPaciente}")
    public ResponseEntity<EnderecoEntity> alterar(@PathVariable("idPaciente") Integer idPaciente,
                                                    @RequestBody EnderecoForm enderecoForm) throws SQLException {

            PacienteEntity paciente = pacienteRepository.findById(idPaciente).orElseThrow(EntityNotFoundException::new);
            EnderecoEntity endereco = enderecoForm.toEntity(paciente);

            enderecoRepository.save(endereco);

            return new ResponseEntity<>(endereco, HttpStatus.OK);
        }

    @DeleteMapping("/deletar/{idPaciente}")
    public ResponseEntity<EnderecoEntity> deletar(@PathVariable("idPaciente") Integer idPaciente) {

        PacienteEntity paciente = pacienteRepository.findById(idPaciente).orElseThrow(EntityNotFoundException::new);
        EnderecoEntity endereco = enderecoRepository.findById(idPaciente).orElseThrow(EntityNotFoundException::new);

        enderecoRepository.delete(endereco);

        return new ResponseEntity<>(endereco, HttpStatus.OK);
    }

}
