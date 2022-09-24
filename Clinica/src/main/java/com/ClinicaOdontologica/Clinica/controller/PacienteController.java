package com.ClinicaOdontologica.Clinica.controller;

import com.ClinicaOdontologica.Clinica.controller.dto.PacienteDto;
import com.ClinicaOdontologica.Clinica.controller.dto.PacienteForm;
import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import com.ClinicaOdontologica.Clinica.exception.BadRequestException;
import com.ClinicaOdontologica.Clinica.exception.ResourceNotFoundException;
import com.ClinicaOdontologica.Clinica.repository.IPacienteRepository;
import com.ClinicaOdontologica.Clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")


public class PacienteController {

    @Autowired
    PacienteService service;

    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    IPacienteRepository repository;

    @PostMapping("/salvar")
    @Transactional
    public ResponseEntity<PacienteDto> cadastrarPaciente(@RequestBody PacienteForm pacienteForm){
        PacienteEntity novoPaciente = pacienteForm.toEntity();//converte o pacienteForm para pacienteEntity
        pacienteRepository.save(novoPaciente);

        return ResponseEntity.ok(novoPaciente.toPacienteDto());
    }

    @GetMapping
    public List<PacienteEntity> buscarTodos() throws ResourceNotFoundException, SQLException {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public PacienteEntity buscarPorId(@RequestParam("id") int id) throws ResourceNotFoundException, SQLException {
        return service.buscarPorId(id).isEmpty() ? new PacienteEntity() : service.buscarPorId(id).get();
    }

    @PatchMapping
    public ResponseEntity<PacienteEntity> alterar(@RequestBody PacienteEntity pacienteEntity) throws ResourceNotFoundException, SQLException {
        Optional<PacienteEntity> pacienteEntityOptional = service.buscarPorId(pacienteEntity.getId());

        if (pacienteEntityOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.alterar(pacienteEntity);


        return ResponseEntity.ok(pacienteEntityOptional.get());
    }

    @DeleteMapping("/{id}")

    public ResponseEntity excluir(@PathVariable Integer id) throws BadRequestException {

        try {
            service.excluir(id);
            return ResponseEntity.ok("Paciente excluído com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado!");
        }
    }
}


