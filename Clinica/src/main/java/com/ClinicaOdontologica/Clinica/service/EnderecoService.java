package com.ClinicaOdontologica.Clinica.service;

import com.ClinicaOdontologica.Clinica.Dao.IDao;
import com.ClinicaOdontologica.Clinica.entity.EnderecoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service

public class EnderecoService {

    @Autowired
    IDao <EnderecoEntity> enderecoDAOH2;

    public EnderecoEntity salvar (EnderecoEntity enderecoEntity) throws SQLException {
        return enderecoDAOH2.salvar(enderecoEntity);
    }

    public List<EnderecoEntity> buscarTodos() throws SQLException {
        return enderecoDAOH2.buscarTodos();
    }

    public void alterar (EnderecoEntity enderecoEntity) throws SQLException {
        enderecoDAOH2.alterar(enderecoEntity);
    }

    public Optional<EnderecoEntity> buscarPorId (int id) throws SQLException {
        return enderecoDAOH2.buscarPorId(id);
    }

    public void excluir (int id) throws SQLException {
        enderecoDAOH2.excluir(id);
    }
}
