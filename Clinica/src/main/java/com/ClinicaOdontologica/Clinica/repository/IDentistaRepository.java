package com.ClinicaOdontologica.Clinica.repository;

import com.ClinicaOdontologica.Clinica.entity.DentistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistaRepository extends JpaRepository<DentistaEntity, Integer> {
    DentistaEntity findDentistaEntityByNome(String nome);
}
