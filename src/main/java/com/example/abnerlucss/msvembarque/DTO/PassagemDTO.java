package com.example.abnerlucss.msvembarque.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class PassagemDTO {

    private Integer idPassagem;

    private String aeroporto;

    private String destino;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime dataHoraEmbarque;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime dataHoraDesembarque;

    private int numeroAssento;

    private String nomeClasse;

    private String nomeCompanhia;
    
}
