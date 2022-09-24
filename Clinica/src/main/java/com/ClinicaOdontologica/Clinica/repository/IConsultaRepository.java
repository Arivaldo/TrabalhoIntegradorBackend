package com.ClinicaOdontologica.Clinica.repository;

import com.ClinicaOdontologica.Clinica.entity.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IConsultaRepository extends JpaRepository<ConsultaEntity, Integer> {
    List<ConsultaEntity> findConsultaEntityByPacienteId(Integer idPaciente);
    List<ConsultaEntity> findConsultaEntityByDentistaId(Integer idDentista);

    //Procurando a consulta por paciente e dentista respectivamente
}
