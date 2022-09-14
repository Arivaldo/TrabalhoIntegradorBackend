package com.ClinicaOdontologica.Clinica.Dao.impl;

import com.ClinicaOdontologica.Clinica.Dao.ConfiguracaoJDBC;
import com.ClinicaOdontologica.Clinica.Dao.IDao;
import com.ClinicaOdontologica.Clinica.entity.DentistaEntity;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.apache.logging.log4j.LogManager.getLogger;


@Configuration
@Repository
public class DentistaDAOH2 implements IDao<DentistaEntity> {

    private ConfiguracaoJDBC configuracaoJDBC;

    final static Logger log = getLogger(DentistaDAOH2.class);

    public DentistaDAOH2(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    @Override
    public DentistaEntity salvar(DentistaEntity dentistaEntity) throws SQLException {

        log.info("Abrindo conexao com o banco de dados.");

        String SQLInsert = String.format("INSERT INTO dentista(id, nome, sobrenome, matricula)" +
                " VALUES (%s, '%s','%s','%s')",dentistaEntity.getId(),dentistaEntity.getNome(), dentistaEntity.getSobrenome(), dentistaEntity.getMatriculaCad());
        Connection connection = null;

        try {
            log.info("Cadastrando Dentista : " + dentistaEntity.getNome());
            connection = configuracaoJDBC.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(SQLInsert, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                dentistaEntity.setId(resultSet.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Erro ao cadastrar dentista: " + e.getMessage());
        } finally {
            log.info("Fechando a conexão");
            connection.close();
        }
        return dentistaEntity;
    }

    @Override
    public List<DentistaEntity> buscarTodos() throws SQLException {
        log.debug("Abrindo conexao com o banco de dados");
        Connection connection = null;
        Statement statement = null;
        String SQLSelect = "SELECT * FROM dentista";

        List<DentistaEntity> dentistaEntities = new ArrayList<>();

        try {
            connection = configuracaoJDBC.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLSelect);

            log.debug("Buscar Dentistas");
            while (resultSet.next()) {
              dentistaEntities.add(criarObjetoDentista(resultSet));
                   }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            log.debug("Fechando a conexão no banco");
            connection.close();
        }
        return dentistaEntities;
    }

    @Override
    public void alterar(DentistaEntity dentistaEntity) throws SQLException {

        String SQLUpdate = String.format("UPDATE dentista SET nome = '%s', sobrenome = '%s', matriculaCad = '%s' WHERE id = %s;",
                dentistaEntity.getId(), dentistaEntity.getNome(), dentistaEntity.getSobrenome(), dentistaEntity.getMatriculaCad());

        Connection connection = null;

        try {
            log.info("Alterando valor produto: " + dentistaEntity.getId());
            connection = configuracaoJDBC.getConnection();
            //Executando o comando SQLUpdate
            Statement statement = connection.createStatement();
            statement.execute(SQLUpdate);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Erro ao alterar o dentista: " + e.getMessage());
        } finally {
            log.info("Fechando a conexão");
            connection.close();
        }
    }

    @Override
    public Optional<DentistaEntity> buscarPorId(int id) throws SQLException {
        log.debug("Abrindo conexao com o banco de dados");
        Connection connection = null;
        Statement statement = null;
        String SQLSelect = String.format("SELECT * FROM dentista WHERE id = %d", id);

        try {
            connection = configuracaoJDBC.getConnection();

            log.debug("Buscar Dentista por id: " + id);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLSelect);

            while (resultSet.next()) {

                DentistaEntity dentistaEntity = criarObjetoDentista(resultSet);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            log.debug("Fechando a conexão no banco");
            connection.close();
        }
        return Optional.empty();
    }

    @Override
    public void excluir(int id) throws SQLException {

        log.info("Abrindo conexão com o banco de dados");
        Connection connection = null;
        Statement statement = null;
        String SQLDelete = String.format("DELETE FROM dentista WHERE id = %d", id);


        try {
            connection = configuracaoJDBC.getConnection();
            log.info("Excluindo dentista: " + id);
            statement = connection.createStatement();
            statement.execute(SQLDelete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            log.info("Fechando a conexão");
            connection.close();
        }
    }

    private DentistaEntity criarObjetoDentista(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String nome = resultSet.getString("nome");
        String sobrenome = resultSet.getString("sobrenome");
        String matriculaCad = resultSet.getString("matriculaCad");
        return new DentistaEntity(id, nome, sobrenome, matriculaCad);


    }
}
