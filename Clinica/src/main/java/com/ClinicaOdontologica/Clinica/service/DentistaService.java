package com.ClinicaOdontologica.Clinica.service;

import com.ClinicaOdontologica.Clinica.entity.DentistaEntity;
import com.ClinicaOdontologica.Clinica.repository.IDentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class DentistaService {

    @Autowired
    IDentistaRepository dentistaRepository;


    public DentistaEntity salvar (DentistaEntity dentistaEntity){
        return dentistaRepository.save(dentistaEntity);
    }

     public List<DentistaEntity> buscarTodos() throws SQLException {
        return dentistaRepository.findAll();
    }

    public void alterar (DentistaEntity dentistaEntity) throws SQLException {
    }

    public Optional<DentistaEntity> buscarPorId (int id) throws SQLException {
        return dentistaRepository.findById(id);
    }

    public void excluir (int id) throws SQLException {
        dentistaRepository.deleteById(id);
    }
}