package com.example.abnerlucss.msvvalidationboarding.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "embarque")
public class Embarque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_embarque")
    private Integer idEmbarque;

    @Column(name = "data_hora_embarque")
    private LocalDateTime dataHoraEmbarque;

    @Column(name = "classe")
    private String classe;

    @Column(name = "codigo_localizador")
    private String codigoLocalizador;

    @Column(name = "identificador_comp")
    private String identificadorComp;

    @Column(name = "numero_assento")
    private Integer numeroAssento;

    @ManyToOne
    @JoinColumn(name = "id_voo")
    private Voo voo;

    @Column(name = "destino")
    private String destino;


    public Embarque(LocalDateTime dataHoraEmbarque, String classe, String codigoLocalizador, String identificadorComp, Integer numeroAssento, String destino) {
        this.dataHoraEmbarque = dataHoraEmbarque;
        this.classe = classe;
        this.codigoLocalizador = codigoLocalizador;
        this.identificadorComp = identificadorComp;
        this.numeroAssento = numeroAssento;
        this.destino = destino;
    }

    public Embarque(LocalDateTime dataHoraEmbarque, String classe, String codigoLocalizador, String identificadorComp, Integer numeroAssento, Voo voo, String destino) {
        this.dataHoraEmbarque = dataHoraEmbarque;
        this.classe = classe;
        this.codigoLocalizador = codigoLocalizador;
        this.identificadorComp = identificadorComp;
        this.numeroAssento = numeroAssento;
        this.voo = voo;
        this.destino = destino;
    }

}
