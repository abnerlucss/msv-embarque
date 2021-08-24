package com.example.abnerlucss.msvvalidationboarding.repositories;

import com.example.abnerlucss.msvvalidationboarding.models.Portao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortaoRepository extends JpaRepository<Portao, Integer> {
    @Query(value = "select * from portao where status = 'ativo'", nativeQuery = true)
    List<Portao> listarPortoesAtivos();

    @Query(value = "select * from portao where status = 'inativo'", nativeQuery = true)
    List<Portao> listarPortoesInativos();
    
}
