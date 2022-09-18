package com.ClinicaOdontologica.Clinica.repository;

import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<PacienteEntity, Integer> {
    PacienteEntity findPacienteEntityByNome(String name);
}