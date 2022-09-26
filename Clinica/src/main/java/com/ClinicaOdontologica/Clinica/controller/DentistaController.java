package com.ClinicaOdontologica.Clinica.controller;

import com.ClinicaOdontologica.Clinica.controller.dto.DentistaDto;
import com.ClinicaOdontologica.Clinica.controller.dto.DentistaForm;
import com.ClinicaOdontologica.Clinica.entity.DentistaEntity;
import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import com.ClinicaOdontologica.Clinica.repository.IDentistaRepository;
import com.ClinicaOdontologica.Clinica.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private IDentistaRepository dentistaRepository;

    @PostMapping("/{idPaciente}")
    @Transactional
    public ResponseEntity cadastrarDentista(@PathVariable("idPaciente") Integer idPaciente,
                                            @RequestBody DentistaForm dentistaForm) {

        PacienteEntity paciente = pacienteRepository.findById(idPaciente).orElseThrow(EntityNotFoundException::new);
        DentistaEntity dentista = dentistaForm.toEntity(paciente);

        dentistaRepository.save(dentista);

        DentistaDto dentistaDto = dentista.toDentistaDto();

        return ResponseEntity.ok(dentistaDto);

    }
}

