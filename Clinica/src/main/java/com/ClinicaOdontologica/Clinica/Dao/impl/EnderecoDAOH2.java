package com.ClinicaOdontologica.Clinica.Dao.impl;

import com.ClinicaOdontologica.Clinica.Dao.ConfiguracaoJDBC;
import com.ClinicaOdontologica.Clinica.Dao.IDao;
import com.ClinicaOdontologica.Clinica.entity.EnderecoEntity;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.apache.logging.log4j.LogManager.getLogger;

@Configuration
public class EnderecoDAOH2  implements IDao <EnderecoEntity> {

    private ConfiguracaoJDBC configuracaoJDBC;

    final static Logger log = getLogger(EnderecoDAOH2.class);

    @Override
    public EnderecoEntity salvar(EnderecoEntity enderecoEntity) throws SQLException {
        log.info("Abrindo conexao com o banco de dados.");

        String SQLInsert = String.format("INSERT INTO endereco (rua, numero, cep, bairro)" +
                " VALUES ('%s','%s','%s', '%s')",
                enderecoEntity.getRua(), enderecoEntity.getNumero(), enderecoEntity.getCep(), enderecoEntity.getBairro());
        Connection connection = null;

        try {
            log.info("Cadastrando Endereco : " + enderecoEntity.getRua());

            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver", "jdbc:h2:~/test" +
                    "INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");
            connection = configuracaoJDBC.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQLInsert, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                enderecoEntity.setId(resultSet.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Erro ao cadastrar endereco: " + e.getMessage());
        } finally {
            log.info("Fechando a conexão");
            connection.close();
        }
        return enderecoEntity;
    }

    @Override
    public List<EnderecoEntity> buscarTodos() throws SQLException {
        log.debug("Abrindo conexao com o banco de dados");
        Connection connection = null;
        Statement statement = null;
        String SQLSelect = "SELECT * FROM endereco";

        List<EnderecoEntity> enderecoEntities = new ArrayList<>();

        try {

            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver", "jdbc:h2:~/test" +
                    "INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");
            connection = configuracaoJDBC.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLSelect);

            log.debug("Buscar Endereco");
            while (resultSet.next()) {
                enderecoEntities.add(new EnderecoEntity(resultSet.getInt("id"), resultSet.getString("rua"),
                        resultSet.getString("numero"), resultSet.getString("bairro"), resultSet.getString("cep")));

            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            log.debug("Fechando a conexão no banco");
            connection.close();
        }
        return enderecoEntities;
    }

    @Override
    public void alterar(EnderecoEntity enderecoEntity) throws SQLException {

        String SQLUpdate = String.format("UPDATE anterar SET rua = '%s', numero = '%s', bairro = '%s', cep = '%s' WHERE id = %s;",
                enderecoEntity.getId(), enderecoEntity.getRua(), enderecoEntity.getNumero(), enderecoEntity.getBairro(), enderecoEntity.getCep());

        Connection connection = null;

        try {
            log.info("Alterando valor produto: " + enderecoEntity.getId());
            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver", "jdbc:h2:~/test;" +
                    "INIT=RUBSCRIPT FROM 'create.sql'", "sa", "");

            connection = configuracaoJDBC.getConnection();
            //Executando o comando SQLUpdate
            Statement statement = connection.createStatement();
            statement.execute(SQLUpdate);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Erro ao alterar o endereco: " + e.getMessage());
        } finally {
            log.info("Fechando a conexão");
            connection.close();
        }

    }

    @Override
    public Optional<EnderecoEntity> buscarPorId(int id) throws SQLException {
        log.debug("Abrindo conexao com o banco de dados");
        Connection connection = null;
        Statement statement = null;
        String SQLSelect = String.format("SELECT * FROM endereco WHERE id = %d", id);

        try {
            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver", "jdbc:h2:~/test" +
                    "INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");
            connection = configuracaoJDBC.getConnection();

            log.debug("Buscar endereco por id: " + id);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLSelect);

            while (resultSet.next()) {

                EnderecoEntity enderecoEntity = criarObjetoEndereco(resultSet);
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
        String SQLDelete = String.format("DELETE FROM endereco WHERE id = %d", id);


        try {
            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver", "jdbc:h2:~/test" +
                    "INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");
            connection = configuracaoJDBC.getConnection();
            log.info("Excluindo endereco: " + id);
            statement = connection.createStatement();
            statement.execute(SQLDelete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            log.info("Fechando a conexão");
            connection.close();
        }

    }
    private EnderecoEntity criarObjetoEndereco(ResultSet resultSet) throws SQLException {
        return new EnderecoEntity(resultSet.getInt("id"), resultSet.getString("rua"),
                resultSet.getString("numero"),
                resultSet.getString("bairro"),
                resultSet.getString("cep"));
    }
}
