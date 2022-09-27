package com.ClinicaOdontologica.Clinica.repository;

import com.ClinicaOdontologica.Clinica.entity.DentistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDentistaRepository extends JpaRepository<DentistaEntity, Integer> {
    Optional<DentistaEntity> findById(Integer id);
}
