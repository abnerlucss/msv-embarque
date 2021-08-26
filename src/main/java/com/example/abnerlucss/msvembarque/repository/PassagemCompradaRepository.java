package com.example.abnerlucss.msvembarque.repository;

import com.example.abnerlucss.msvembarque.model.PassagemComprada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagemCompradaRepository extends JpaRepository<PassagemComprada, Integer> {
}
