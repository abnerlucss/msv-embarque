package com.example.abnerlucss.msvvalidationboarding.repositories;

import com.example.abnerlucss.msvvalidationboarding.models.Embarque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmbarqueRepository extends JpaRepository<Embarque, Integer> {
    Optional<Embarque> findByCodigoLocalizador(String codigoLocalizador);
}
