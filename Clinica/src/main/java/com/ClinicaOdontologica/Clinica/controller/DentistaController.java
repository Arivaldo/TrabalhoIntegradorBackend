package com.ClinicaOdontologica.Clinica.controller;

import com.ClinicaOdontologica.Clinica.controller.dto.DentistaDto;
import com.ClinicaOdontologica.Clinica.controller.dto.DentistaForm;
import com.ClinicaOdontologica.Clinica.entity.DentistaEntity;
import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import com.ClinicaOdontologica.Clinica.exception.BadRequestException;
import com.ClinicaOdontologica.Clinica.exception.ResourceNotFoundException;
import com.ClinicaOdontologica.Clinica.repository.IDentistaRepository;
import com.ClinicaOdontologica.Clinica.repository.IPacienteRepository;
import com.ClinicaOdontologica.Clinica.service.DentistaService;
import org.apache.coyote.Response;
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
@RequestMapping("/dentista")
public class DentistaController {

    @Autowired
    DentistaService service;

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private IDentistaRepository dentistaRepository;

    @PostMapping("/{idPaciente}")
    @Transactional
    public ResponseEntity cadastrarDentista(@PathVariable("idPaciente") int idPaciente,
                                            @RequestBody DentistaForm dentistaForm) {

        PacienteEntity paciente = IPacienteRepository.findById(idPaciente).orElseThrow(EntityNotFoundException::new);
        DentistaEntity dentista = DentistaForm.toEntity(paciente);

        IDentistaRepository.save(dentista);

        DentistaDto dentistaDto = dentista.toDentistaDto();

        return ResponseEntity.ok(dentistaDto);

        @GetMapping
        public List<DentistaEntity> buscarTodos () throws ResourceNotFoundException, SQLException {
            return service.buscarTodos();
        }

        @GetMapping("/{id}")
        public DentistaEntity buscarPorId ( @RequestParam("id") int id) throws ResourceNotFoundException, SQLException {
            return service.buscarPorId(id).isEmpty() ? new DentistaEntity() : service.buscarPorId(id).get();

        }

        @PatchMapping
        public ResponseEntity<DentistaEntity> alterar (@RequestBody DentistaEntity dentistaEntity) throws
        BadRequestException, SQLException {
            Optional<DentistaEntity> dentistaEntityOptional = service.buscarPorId(dentistaEntity.getId());

            if (dentistaEntityOptional.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            service.alterar(dentistaEntity);


            return ResponseEntity.ok(dentistaEntityOptional.get());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity excluir (@PathVariable Integer id) throws SQLException {
            ResponseEntity responseEntity = null;

            if (service.buscarPorId(id) == null) {
                responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
            } else {
                service.excluir(id);
                System.out.println("Dentista excluído com sucesso!");
            }
            return responseEntity;
        }

        @ExceptionHandler({BadRequestException.class})
        public ResponseEntity<String> processarErrorBadRequest (BadRequestException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        @ExceptionHandler({ResourceNotFoundException.class})
        public ResponseEntity<String> processarErrorNotFound (ResourceNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}

