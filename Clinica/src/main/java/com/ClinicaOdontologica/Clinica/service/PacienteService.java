package com.ClinicaOdontologica.Clinica.service;

import com.ClinicaOdontologica.Clinica.Dao.IDao;
import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service

public class PacienteService {

    @Autowired
    IDao <PacienteEntity> pacienteDAOH2;

    public PacienteEntity salvar (PacienteEntity pacienteEntity) throws SQLException {
        return pacienteDAOH2.salvar(pacienteEntity);
    }

    public List<PacienteEntity> buscarTodos() throws SQLException {
        return pacienteDAOH2.buscarTodos();
    }

    public void alterar (PacienteEntity pacienteEntity) throws SQLException {
        pacienteDAOH2.alterar(pacienteEntity);
    }

    public Optional<PacienteEntity> buscarPorId (int id) throws SQLException {
        return pacienteDAOH2.buscarPorId(id);
    }

    public void excluir (int id) throws SQLException {
        pacienteDAOH2.excluir(id);
    }
}
