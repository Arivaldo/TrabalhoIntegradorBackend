package com.ClinicaOdontologica.Clinica.controller;

import com.ClinicaOdontologica.Clinica.entity.EnderecoEntity;
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


    @PostMapping
    public EnderecoEntity salvar(@RequestBody EnderecoEntity enderecoEntity) throws SQLException {
        return service.salvar(enderecoEntity);
    }

    @GetMapping
    public List<EnderecoEntity> buscarTodos() throws SQLException {
        return service.buscarTodos();
    }

    @RequestMapping(value = "/buscarId")
    public EnderecoEntity buscarPorId(@RequestParam ("id") int id) throws SQLException {
        return service.buscarPorId(id).isEmpty()? new EnderecoEntity() : service.buscarPorId(id).get();
    }

    @PatchMapping
    public ResponseEntity<EnderecoEntity> alterar(@RequestBody EnderecoEntity enderecoEntity) throws SQLException {
        ResponseEntity responseEntity = null;

        if(service.buscarPorId(enderecoEntity.getId()) == null){
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @DeleteMapping
    public ResponseEntity excluir(@PathVariable Integer id) throws SQLException {
        ResponseEntity responseEntity = null;

        if(service.buscarPorId(id) == null){
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }
}
