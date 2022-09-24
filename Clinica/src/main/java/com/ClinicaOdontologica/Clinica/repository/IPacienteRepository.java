package com.ClinicaOdontologica.Clinica.repository;

import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<PacienteEntity, Integer> {
    Optional<PacienteEntity> findById(String nome);
}