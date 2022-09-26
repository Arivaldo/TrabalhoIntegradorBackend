package com.ClinicaOdontologica.Clinica.security.usuario;

import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UsuarioLogado implements UserDetails {

    private PacienteEntity pacienteEntity;

    private User springUserDetails;


    public UsuarioLogado(PacienteEntity pacienteEntity) {
        this.pacienteEntity = pacienteEntity;
        springUserDetails = new User(pacienteEntity.getUsername(), pacienteEntity.getPassword(), List.of());
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return springUserDetails.getAuthorities();
    }

    @Override
    public String getPassword() {
        return springUserDetails.getPassword();
    }

    @Override
    public String getUsername() {
        return springUserDetails.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return springUserDetails.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return springUserDetails.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return springUserDetails.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return springUserDetails.isEnabled();
    }
}