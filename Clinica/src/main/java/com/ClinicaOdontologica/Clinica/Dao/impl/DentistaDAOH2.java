package com.ClinicaOdontologica.Clinica.Dao.impl;

import com.ClinicaOdontologica.Clinica.Dao.ConfiguracaoJDBC;
import com.ClinicaOdontologica.Clinica.Dao.IDao;
import com.ClinicaOdontologica.Clinica.model.Dentista;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.apache.logging.log4j.LogManager.getLogger;

public class DentistaDAOH2 implements IDao<Dentista> {

    private ConfiguracaoJDBC configuracaoJDBC;

    final static Logger log = getLogger(DentistaDAOH2.class);

    @Override
    public Dentista salvar(Dentista dentista) throws SQLException {
        log.info("Abrindo conexao com o banco de dados.");
        String SQLInsert = String.format("INSERT INTO dentista (nome, sobrenome, matriculaCad)" +
                " VALUES ('%s','%s','%s')", dentista.getNome(), dentista.getSobrenome(), dentista.getMatriculaCad());
        Connection connection = null;
        try {
            log.info("Cadastrando Dentista : " + dentista.getNome());

            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver", "jdbc:h2:~/test" +
                    "INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");
            connection = configuracaoJDBC.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQLInsert, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                dentista.setId(resultSet.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Erro ao cadastrar dentista: " + e.getMessage());
        } finally {
            log.info("Fechando a conexão");
            connection.close();
        }
        return dentista;
    }

    @Override
    public List<Dentista> buscarTodos() throws SQLException {
     log.debug("Abrindo conexao com o banco de dados");
     Connection connection = null;
     Statement statement = null;
     String SQLSelect = "SELECT * FROM dentista";

     List<Dentista>dentistas = new ArrayList<>();

        try {
            log.info("Cadastrando Dentista : " + dentista.getNome());

            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver", "jdbc:h2:~/test" +
                    "INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");
            connection = configuracaoJDBC.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.getGeneratedKeys();
            log.debug("Buscar Dentistas");

            while(resultado.next()){
                dentistas.add(criarObjetoDentista(resultado));
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }finally {
            log.debug("Fechando a conexão no banco");
            stmt.close();
        }

        return dentistas;
    }


    @Override
    public void alterar(Dentista dentista) throws SQLException {

    }

    @Override
    public Optional<Dentista> buscarPorId(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void excluir(int id) throws SQLException {

    }


}
