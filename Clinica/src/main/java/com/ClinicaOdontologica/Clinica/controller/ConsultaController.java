package com.ClinicaOdontologica.Clinica.controller;

import com.ClinicaOdontologica.Clinica.controller.dto.ConsultaForm;
import com.ClinicaOdontologica.Clinica.entity.ConsultaEntity;
import com.ClinicaOdontologica.Clinica.entity.DentistaEntity;
import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import com.ClinicaOdontologica.Clinica.exception.BadRequestException;
import com.ClinicaOdontologica.Clinica.exception.ResourceNotFoundException;
import com.ClinicaOdontologica.Clinica.repository.IConsultaRepository;
import com.ClinicaOdontologica.Clinica.repository.IDentistaRepository;
import com.ClinicaOdontologica.Clinica.repository.IEnderecoRepository;
import com.ClinicaOdontologica.Clinica.repository.IPacienteRepository;
import com.ClinicaOdontologica.Clinica.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consulta")

public class ConsultaController {

    @Autowired
    ConsultaService service;

    //Estanciando todos os repositorys para não ter erro
    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    IDentistaRepository dentistaRepository;

    @Autowired
    IEnderecoRepository enderecoRepository;

    @Autowired
    IConsultaRepository consultaRepository;


   // @PostMapping("/{idPaciente}")
    //@Transactional

    //public ResponseEntity cadastrarConsulta(@PathVariable("idPaciente") int idPaciente){


    }
    //Apagar esse colchete;


//    @GetMapping
//    public List<ConsultaEntity> buscarTodos() throws ResourceNotFoundException, SQLException {
//        return service.buscarTodos();
//    }
//
//    @GetMapping("/{id}")
//    public ConsultaEntity buscarPorId(@RequestParam ("id") int id) throws ResourceNotFoundException, SQLException {
//        return service.buscarPorId(id).isEmpty() ? new ConsultaEntity() : service.buscarPorId(id).get();
//
//    }
//
//    @PatchMapping
//    public ResponseEntity<ConsultaEntity> alterar(@RequestBody ConsultaEntity consultaEntity) throws BadRequestException, SQLException {
//        Optional<ConsultaEntity> consultaEntityOptional = service.buscarPorId(consultaEntity.getId());
//
//        if (consultaEntityOptional.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        service.alterar(consultaEntity);
//
//
//        return ResponseEntity.ok(consultaEntityOptional.get());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity excluir(@PathVariable Integer id) throws SQLException {
//        ResponseEntity responseEntity = null;
//
//        if(service.buscarPorId(id) == null){
//            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
//        }else{
//            service.excluir(id);
//            System.out.println("Consulta cancelada com sucesso!");
//        }
//        return responseEntity;
//    }
//
//    @ExceptionHandler({BadRequestException.class})
//    public ResponseEntity<String> processarErrorBadRequest(BadRequestException ex){
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//    }
//    @ExceptionHandler({ResourceNotFoundException.class})
//    public ResponseEntity<String> processarErrorNotFound(ResourceNotFoundException ex){
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//    }

