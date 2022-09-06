package com.ClinicaOdontologica.Clinica.Dao.impl;

import com.ClinicaOdontologica.Clinica.Dao.ConfiguracaoJDBC;
import com.ClinicaOdontologica.Clinica.Dao.IDao;
import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
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
public class PacienteDAOH2 implements IDao <PacienteEntity> {

    private ConfiguracaoJDBC configuracaoJDBC;

    final static Logger log = getLogger(PacienteDAOH2.class);

    @Override
    public PacienteEntity salvar(PacienteEntity pacienteEntity) throws SQLException {
        log.info("Abrindo conexao com o banco de dados.");

        String SQLInsert = String.format("INSERT INTO paciente (nome, sobrenome, rg, dataAlta)" +
                " VALUES ('%s','%s','%s', '%s')", pacienteEntity.getNome(), pacienteEntity.getSobrenome(), pacienteEntity.getRg(), pacienteEntity.getDataAlta());
        Connection connection = null;

        try {
            log.info("Cadastrando Paciente : " + pacienteEntity.getNome());

            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver", "jdbc:h2:~/test" +
                    "INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");
            connection = configuracaoJDBC.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQLInsert, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                pacienteEntity.setId(resultSet.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Erro ao cadastrar paciente: " + e.getMessage());
        } finally {
            log.info("Fechando a conexão");
            connection.close();
        }
        return pacienteEntity;
    }

    @Override
    public List<PacienteEntity> buscarTodos() throws SQLException {
        log.debug("Abrindo conexao com o banco de dados");
        Connection connection = null;
        Statement statement = null;
        String SQLSelect = "SELECT * FROM paciente";

        List<PacienteEntity> pacienteEntities = new ArrayList<>();

        try {

            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver", "jdbc:h2:~/test" +
                    "INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");
            connection = configuracaoJDBC.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLSelect);

            log.debug("Buscar Pacientes");
            while (resultSet.next()) {
                pacienteEntities.add(criarObjetoPaciente(resultSet));

            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            log.debug("Fechando a conexão no banco");
            connection.close();
        }
        return pacienteEntities;
    }

    @Override
    public void alterar(PacienteEntity pacienteEntity) throws SQLException {

    }

    @Override
    public Optional<PacienteEntity> buscarPorId(int id) throws SQLException {
        log.debug("Abrindo conexao com o banco de dados");
        Connection connection = null;
        Statement statement = null;
        String SQLSelect = String.format("SELECT * FROM paciente WHERE id = %d", id);

        try {
            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver", "jdbc:h2:~/test" +
                    "INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");
            connection = configuracaoJDBC.getConnection();

            log.debug("Buscar Paciente por id: " + id);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLSelect);

            while (resultSet.next()) {

                PacienteEntity pacienteEntity = criarObjetoPaciente(resultSet);
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
        String SQLDelete = String.format("DELETE FROM paciente WHERE id = %d", id);


        try {
            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver", "jdbc:h2:~/test" +
                    "INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");
            connection = configuracaoJDBC.getConnection();
            log.info("Excluindo paciente: " + id);
            statement = connection.createStatement();
            statement.execute(SQLDelete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            log.info("Fechando a conexão");
            connection.close();
        }

    }

    private PacienteEntity criarObjetoPaciente(ResultSet resultSet) throws SQLException {
        PacienteEntity pacienteEntity = new PacienteEntity();
        pacienteEntity.setId(resultSet.getInt("id"));
        pacienteEntity.setNome(resultSet.getString("nome"));
        pacienteEntity.setSobrenome(resultSet.getString("sobrenome"));
        pacienteEntity.setRg(resultSet.getString("rg"));
        pacienteEntity.setDataAlta(resultSet.getDate("dataAlta"));
        return pacienteEntity;
    }
}
