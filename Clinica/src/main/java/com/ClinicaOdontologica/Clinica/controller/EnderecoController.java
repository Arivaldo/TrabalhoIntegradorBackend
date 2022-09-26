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

    @PatchMapping
    public ResponseEntity<EnderecoEntity> alterar(@RequestBody EnderecoEntity enderecoEntity) throws SQLException {
        ResponseEntity responseEntity = null;

        if(service.buscarPorId(enderecoEntity.getId()) == null){
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Integer id) throws SQLException {

        try {
            service.excluir(id);
            return ResponseEntity.ok("Endereco excluído com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco não encontrado!");
        }
    }

}
