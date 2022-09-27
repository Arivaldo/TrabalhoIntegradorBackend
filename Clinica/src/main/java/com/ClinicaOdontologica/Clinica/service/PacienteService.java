package com.ClinicaOdontologica.Clinica.service;

import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import com.ClinicaOdontologica.Clinica.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    IPacienteRepository pacienteRepository;

    public PacienteEntity salvar (PacienteEntity pacienteEntity) throws SQLException {
        return pacienteRepository.save(pacienteEntity);
    }

    public List<PacienteEntity> buscarTodos() throws SQLException {
        return pacienteRepository.findAll();
    }

    public void alterar (PacienteEntity pacienteEntity) throws SQLException {
        pacienteRepository.saveAndFlush(pacienteEntity);
    }

    public Optional<PacienteEntity> buscarPorId (int id) throws SQLException {
        return pacienteRepository.findById(id);
    }

    public void excluir (int id) throws SQLException {
        pacienteRepository.deleteById(id);
    }
}
