package com.example.abnerlucss.msvembarque.repositories;

import com.example.abnerlucss.msvembarque.models.PassagemComprada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagemCompradaRepository extends JpaRepository<PassagemComprada, Integer> {
}
