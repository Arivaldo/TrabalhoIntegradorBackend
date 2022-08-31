package com.ClinicaOdontologica.Clinica.Dao.impl;

import com.ClinicaOdontologica.Clinica.Dao.ConfiguracaoJDBC;
import com.ClinicaOdontologica.Clinica.Dao.IDao;
import com.ClinicaOdontologica.Clinica.model.Endereco;
import com.ClinicaOdontologica.Clinica.model.Paciente;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.apache.logging.log4j.LogManager.getLogger;

public class PacienteDAOH2 implements IDao <Paciente> {

    private ConfiguracaoJDBC configuracaoJDBC;

    final static Logger log = getLogger(PacienteDAOH2.class);

    @Override
    public Paciente salvar(Paciente paciente) throws SQLException {
        return null;
    }

    @Override
    public List<Paciente> buscarTodos() throws SQLException {
        return null;
    }

    @Override
    public void alterar(Paciente paciente) throws SQLException {

    }

    @Override
    public Optional<Paciente> buscarPorId(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void excluir(int id) throws SQLException {

    }
}
