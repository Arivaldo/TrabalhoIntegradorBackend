package com.ClinicaOdontologica.Clinica.service;

import com.ClinicaOdontologica.Clinica.entity.ConsultaEntity;
import com.ClinicaOdontologica.Clinica.repository.IConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    IConsultaRepository consultaRepository;

    public ConsultaEntity salvar (ConsultaEntity consultaEntity) throws SQLException {
        return consultaRepository.save(consultaEntity);
    }

    public void alterar (ConsultaEntity consultaEntity) throws SQLException {
        consultaRepository.saveAndFlush(consultaEntity);
    }

    public void excluir (int id) throws SQLException {
        consultaRepository.deleteById(id);
    }

    public List<ConsultaEntity> buscarTodos () throws SQLException {
        return consultaRepository.findAll();
    }

    public Optional<ConsultaEntity> buscarPorId (int id) throws SQLException {
        return consultaRepository.findById(id);
    }
}
