package com.ClinicaOdontologica.Clinica.repository;

import com.ClinicaOdontologica.Clinica.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEnderecoRepository extends JpaRepository <EnderecoEntity, Integer> {
    @Query("select e from EnderecoEntity where e.rua = ?1")
    EnderecoEntity findEnderecoByRua(String rua);
}
