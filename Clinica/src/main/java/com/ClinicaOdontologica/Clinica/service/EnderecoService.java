package com.ClinicaOdontologica.Clinica.service;

import com.ClinicaOdontologica.Clinica.entity.EnderecoEntity;
import com.ClinicaOdontologica.Clinica.repository.IEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service

public class EnderecoService {

    @Autowired
    IEnderecoRepository enderecoRepository;

    public EnderecoEntity salvar (EnderecoEntity enderecoEntity) throws SQLException {
        return enderecoRepository.save(enderecoEntity);
    }

    public List<EnderecoEntity> buscarTodos() throws SQLException {
        return enderecoRepository.findAll();
    }

    public void alterar (EnderecoEntity enderecoEntity) throws SQLException {
    }

    public Optional<EnderecoEntity> buscarPorId (int id) throws SQLException {
        return enderecoRepository.findById(id);
    }

    public void excluir (int id) throws SQLException {
        enderecoRepository.deleteById(id);
    }
}
