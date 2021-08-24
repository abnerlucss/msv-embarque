package com.example.abnerlucss.msvvalidationboarding.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmbarqueDTO {

    private Date dataEmbarque;

    private Date horaEmbarque;

    private String classe;

    private String codigoLocalizador;

    private String identificadorComp;

    private Integer numeroAssento;

    private String destino;

}
