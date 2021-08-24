package com.example.abnerlucss.msvvalidationboarding.DTO;

import com.example.abnerlucss.msvvalidationboarding.models.Portao;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VooDTO {

    private Integer idVoo;

    private String aeroporto;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private Date dataEmbarque;

    @JsonFormat(pattern = "HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date horaEmbarque;

    @JsonFormat(pattern = "HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date horaDesembarque;

    private String destino;

    private String identificadorCompanhia;

    private Integer qtdEconomica;

    private Integer qtdExecutiva;

    private Integer qtdPrimeiraClasse;

    private String status;

    private Integer idPortao;

    public VooDTO(String aeroporto, Date dataEmbarque, Date horaEmbarque, Date horaDesembarque, String destino, String identificadorCompanhia, Integer qtdEconomica, Integer qtdExecutiva, Integer qtdPrimeiraClasse, String status, Integer idPortao) {
        this.aeroporto = aeroporto;
        this.dataEmbarque = dataEmbarque;
        this.horaEmbarque = horaEmbarque;
        this.horaDesembarque = horaDesembarque;
        this.destino = destino;
        this.identificadorCompanhia = identificadorCompanhia;
        this.qtdEconomica = qtdEconomica;
        this.qtdExecutiva = qtdExecutiva;
        this.qtdPrimeiraClasse = qtdPrimeiraClasse;
        this.status = status;
        this.idPortao = idPortao;
    }
}
