package com.ClinicaOdontologica.Clinica.repository;

import com.ClinicaOdontologica.Clinica.entity.DentistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDentistaRepository extends JpaRepository<DentistaEntity, Integer> {
//    @Query("SELECT d FROM DentistaEntity d WHERE d.id = ?1")
    Optional<DentistaEntity> findById(Integer id);
}
