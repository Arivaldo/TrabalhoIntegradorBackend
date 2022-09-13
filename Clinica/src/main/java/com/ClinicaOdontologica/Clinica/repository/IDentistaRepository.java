package com.ClinicaOdontologica.Clinica.repository;

import com.ClinicaOdontologica.Clinica.entity.DentistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IDentistaRepository extends JpaRepository<DentistaEntity, Integer> {
    @Query("select d from DentistaEntity where d.nome = ?1")
    DentistaEntity findDentistaByName(String name);
}
