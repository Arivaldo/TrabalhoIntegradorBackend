package com.ClinicaOdontologica.Clinica.service;

import com.ClinicaOdontologica.Clinica.Dao.IDao;
import com.ClinicaOdontologica.Clinica.entity.DentistaEntity;
import com.ClinicaOdontologica.Clinica.repository.IDentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service

public class DentistaService {

    private IDentistaRepository dentistaRepository;

    @Autowired
    IDao <DentistaEntity> dentistaDAOH2;

    public DentistaEntity salvar (DentistaEntity dentistaEntity) throws SQLException {
        return dentistaDAOH2.salvar(dentistaEntity);
    }

    public List<DentistaEntity> buscarTodos() throws SQLException {
        return dentistaDAOH2.buscarTodos();
    }

    public void alterar (DentistaEntity dentistaEntity) throws SQLException {
        dentistaDAOH2.alterar(dentistaEntity);
    }

    public Optional<DentistaEntity> buscarPorId (int id) throws SQLException {
        return dentistaDAOH2.buscarPorId(id);
    }

    public void excluir (int id) throws SQLException {
        dentistaDAOH2.excluir(id);
    }
}