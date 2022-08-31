package com.ClinicaOdontologica.Clinica.Dao.impl;

import com.ClinicaOdontologica.Clinica.Dao.ConfiguracaoJDBC;
import com.ClinicaOdontologica.Clinica.Dao.IDao;
import com.ClinicaOdontologica.Clinica.model.Endereco;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.apache.logging.log4j.LogManager.getLogger;

public class EnderecoDAOH2  implements IDao <Endereco> {

    private ConfiguracaoJDBC configuracaoJDBC;

    final static Logger log = getLogger(EnderecoDAOH2.class);

    @Override
    public Endereco salvar(Endereco endereco) throws SQLException {
        return null;
    }

    @Override
    public List<Endereco> buscarTodos() throws SQLException {
        return null;
    }

    @Override
    public void alterar(Endereco endereco) throws SQLException {

    }

    @Override
    public Optional<Endereco> buscarPorId(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void excluir(int id) throws SQLException {

    }
}
