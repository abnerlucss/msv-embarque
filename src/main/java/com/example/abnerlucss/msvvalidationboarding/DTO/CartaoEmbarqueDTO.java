package com.example.abnerlucss.msvvalidationboarding.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartaoEmbarqueDTO {

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime dataHoraEmbarque;

    private String classe;

    private String identificadorComp;

    private Integer numeroAssento;

    private Integer numeroPortao;


    private String destino;
}
