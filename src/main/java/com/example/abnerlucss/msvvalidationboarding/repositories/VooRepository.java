package com.example.abnerlucss.msvvalidationboarding.repositories;

import com.example.abnerlucss.msvvalidationboarding.models.Voo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface VooRepository extends JpaRepository<Voo, Integer> {

    @Query(value = "Select * from voo where id_portao = ?1 and data_embarque = ?2", nativeQuery = true)
    List<Voo> buscarVooPorDiaPortao(Integer idPortao, Date dataEmbarque);

    @Query(value = "select * from voo where data_embarque = ?1 and hora_embarque = ?2 and identificador_comp = ?3 and destino = ?4 limit 1",nativeQuery = true)
    Optional<Voo> findByParams(Date dataEmbarque, Date horaEmbarque, String identificadorComp, String Destino);
}
