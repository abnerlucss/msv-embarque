package com.example.abnerlucss.msvembarque.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class VooDTO {

    private Integer idVoo;

    private String partida;

    private String aeroporto;

    private LocalDateTime dataHoraEmbarque;

    private LocalDateTime dataHoraDesembarque;

    private String destino;

    private String identificadorCompanhia;

    private Integer qtdEconomica;

    private Integer qtdExecutiva;

    private Integer qtdPrimeiraClasse;

    private String status;

    private Double precoPrimeiraClasse;

    private Double precoExecutiva;

    private Double precoEconomica;

    private Integer idPortao;

}
