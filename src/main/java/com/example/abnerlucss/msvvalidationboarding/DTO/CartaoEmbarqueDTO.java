package com.example.abnerlucss.msvvalidationboarding.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartaoEmbarqueDTO {

    @JsonFormat(pattern = "HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date horaEmbarque;

    private String classe;

    private String identificadorComp;

    private Integer numeroAssento;

    private Integer numeroPortao;

    private String destino;
}
