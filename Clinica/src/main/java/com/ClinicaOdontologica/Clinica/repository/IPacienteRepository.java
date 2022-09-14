package com.ClinicaOdontologica.Clinica.repository;

import com.ClinicaOdontologica.Clinica.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPacienteRepository extends JpaRepository<PacienteEntity, Integer> {
    @Query("select p from PacienteEntity p where p.nome = ?1")
    PacienteEntity findPacienteByName(String name);
}
