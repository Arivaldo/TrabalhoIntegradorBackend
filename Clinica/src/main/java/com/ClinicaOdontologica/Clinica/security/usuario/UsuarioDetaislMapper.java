package com.ClinicaOdontologica.Clinica.security.usuario;

import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
public class UsuarioDetaislMapper implements UserDetailMapper{

    @Override
    public UserDetails map(Object shouldBeASystemUser) {
        return new UsuarioLogado((PacienteEntity) shouldBeASystemUser);
    }
}