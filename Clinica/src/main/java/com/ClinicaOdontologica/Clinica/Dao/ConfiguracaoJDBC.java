package com.ClinicaOdontologica.Clinica.Dao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
@AllArgsConstructor
@Component
public class ConfiguracaoJDBC {
    private String jdbcDriver;
    private String dbUrl;
    private String usuario;
    private String senha;
    public ConfiguracaoJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/test";
        this.usuario = "sa";
        this.senha = "";
    }

    public Connection getConnection() {
        Connection connection = null;
        try{
            Class.forName(this.jdbcDriver);
            connection = DriverManager.getConnection(this.dbUrl,this.usuario,this.senha);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}

