package com.example.abnerlucss.msvvalidationboarding.repositories;

import com.example.abnerlucss.msvvalidationboarding.models.PassagemComprada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagemCompradaRepository extends JpaRepository<PassagemComprada, Integer> {
}
