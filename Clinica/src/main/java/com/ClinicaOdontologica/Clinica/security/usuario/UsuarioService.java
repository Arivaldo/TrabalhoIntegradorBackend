package com.ClinicaOdontologica.Clinica.security.usuario;

import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import com.ClinicaOdontologica.Clinica.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private UserDetailMapper userDetailsMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        PacienteEntity pacienteS = IPacienteRepository.findByUsername(userName).orElseThrow(EntityNotFoundException::new);

        return userDetailsMapper.map(pacienteS);

    }
}