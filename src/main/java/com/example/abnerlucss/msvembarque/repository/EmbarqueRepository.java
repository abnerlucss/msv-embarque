package com.example.abnerlucss.msvembarque.repository;

import com.example.abnerlucss.msvembarque.model.Embarque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmbarqueRepository extends JpaRepository<Embarque, Integer> {
    Optional<Embarque> findByCodigoLocalizador(String codigoLocalizador);

    @Query(value = "select count(id_embarque) from embarque e where date(data_hora_embarque) = current_date;", nativeQuery = true)
    Integer embarquePrevistosParaHoje();
}
