package com.example.abnerlucss.msvembarque.DTO;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmbarqueDTO {

    private Integer idEmbarque;

    private LocalDateTime dataHoraEmbarque;

    private String classe;

    private String codigoLocalizador;

    private String identificadorComp;

    private Integer numeroAssento;

    private String destino;

    private String partida;

    private String aeroporto;

    private Integer idVoo;

}
