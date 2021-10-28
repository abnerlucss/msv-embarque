package com.example.abnerlucss.msvembarque.repository;

import com.example.abnerlucss.msvembarque.model.Voo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface VooRepository extends JpaRepository<Voo, Integer> {

    @Query(value = "select * from voo v where (CAST(v.data_hora_embarque as DATE) = :dataEmbarque) and v.id_portao = :idPortao and v.partida = :partida and v.aeroporto = :aeroporto", nativeQuery = true)
    List<Voo> buscarVooPorDiaPortao(@Param("dataEmbarque") LocalDate dataEmbarque, @Param("idPortao") Integer idPortao,
                                    @Param("partida") String partida, @Param("aeroporto") String aeroporto

    );

    @Query(value = "select * from voo where data_hora_embarque = ?1 and identificador_comp = ?2 and destino = ?3 and partida = ?4 and aeroporto = ?5 and id_voo = ?6 limit 1", nativeQuery = true)
    Optional<Voo> findByParams(LocalDateTime dataHoraEmbarque, String identificadorComp, String destino, String partida, String aeroporto, Integer idVoo);

    @Query(value = "select count(id_voo) from voo where date(data_hora_embarque) = current_date", nativeQuery = true)
    Integer voosPrevistosParaHoje();
}
