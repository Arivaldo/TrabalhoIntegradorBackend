package com.ClinicaOdontologica.Clinica.controller;

import com.ClinicaOdontologica.Clinica.entity.EnderecoEntity;
import com.ClinicaOdontologica.Clinica.exception.BadRequestException;
import com.ClinicaOdontologica.Clinica.exception.ResourceNotFoundException;
import com.ClinicaOdontologica.Clinica.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/endereco")



public class EnderecoController {

    @Autowired
    EnderecoService service;


    @PostMapping("/salvar")
    public EnderecoEntity salvar(@RequestBody EnderecoEntity enderecoEntity) throws BadRequestException, SQLException {
        return service.salvar(enderecoEntity);
    }

    @GetMapping
    public List<EnderecoEntity> buscarTodos() throws ResourceNotFoundException, SQLException {
        return service.buscarTodos();
    }

    @RequestMapping("/{id}")
    public EnderecoEntity buscarPorId(@RequestParam ("id") int id) throws ResourceNotFoundException, SQLException {
        return service.buscarPorId(id).isEmpty()? new EnderecoEntity() : service.buscarPorId(id).get();
    }

    @PatchMapping
    public ResponseEntity<EnderecoEntity> alterar(@RequestBody EnderecoEntity enderecoEntity) throws ResourceNotFoundException, SQLException {
        ResponseEntity responseEntity = null;

        if(service.buscarPorId(enderecoEntity.getId()) == null){
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Integer id) throws BadRequestException {

        try {
            service.excluir(id);
            return ResponseEntity.ok("Endereco excluído com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco não encontrado!");
        }
    }
    @ExceptionHandler (BadRequestException.class)
    public ResponseEntity badRequestException(BadRequestException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler (ResourceNotFoundException.class)
    public ResponseEntity resourceNotFoundException(ResourceNotFoundException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
