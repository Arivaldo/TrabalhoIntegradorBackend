package com.ClinicaOdontologica.Clinica.controller;

import com.ClinicaOdontologica.Clinica.entity.DentistaEntity;
import com.ClinicaOdontologica.Clinica.exception.BadRequestException;
import com.ClinicaOdontologica.Clinica.exception.ResourceNotFoundException;
import com.ClinicaOdontologica.Clinica.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    @Autowired
    DentistaService service;

    @PostMapping("/salvar")
    public DentistaEntity salvar(@RequestBody DentistaEntity dentistaEntity) throws BadRequestException {
        return service.salvar(dentistaEntity);
    }

    @GetMapping
    public List<DentistaEntity> buscarTodos() throws ResourceNotFoundException, SQLException {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public DentistaEntity buscarPorId(@RequestParam ("id") int id) throws ResourceNotFoundException, SQLException {
        return service.buscarPorId(id).isEmpty() ? new DentistaEntity() : service.buscarPorId(id).get();

    }

    @PatchMapping
    public ResponseEntity<DentistaEntity> alterar(@RequestBody DentistaEntity dentistaEntity) throws BadRequestException, SQLException {
        Optional<DentistaEntity> dentistaEntityOptional = service.buscarPorId(dentistaEntity.getId());

        if (dentistaEntityOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.alterar(dentistaEntity);


        return ResponseEntity.ok(dentistaEntityOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Integer id) throws SQLException {
        ResponseEntity responseEntity = null;

        if(service.buscarPorId(id) == null){
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            service.excluir(id);
            System.out.println("Dentista excluído com sucesso!");
        }
        return responseEntity;
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> processarErrorBadRequest(BadRequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> processarErrorNotFound(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

