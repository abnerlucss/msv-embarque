package com.example.abnerlucss.msvvalidationboarding.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "voo")
public class Voo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voo")
    private Integer idVoo;

    @Column(name = "aeroporto")
    private String aeroporto;

    @Column(name = "data_embarque")
    private Date dataEmbarque;

    @Column(name = "hora_embarque")
    private Date horaEmbarque;

    @Column(name = "hora_desembarque")
    private Date horaDesembarque;

    @Column(name = "destino")
    private String destino;

    @Column(name = "identificador_comp")
    private String identificadorCompanhia;

    @Column(name = "qtd_economica")
    private Integer qtdEconomica;

    @Column(name = "qtd_executiva")
    private Integer qtdExecutiva;

    @Column(name = "qtd_primeira_classe")
    private Integer qtdPrimeiraClasse;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_portao")
    private Portao portao;


    public Voo(String aeroporto, Date dataEmbarque, Date horaEmbarque, Date horaDesembarque, String destino, String identificadorCompanhia, Integer qtdEconomica, Integer qtdExecutiva, Integer qtdPrimeiraClasse, String status, Portao portao) {
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
        this.portao = portao;
    }
}
