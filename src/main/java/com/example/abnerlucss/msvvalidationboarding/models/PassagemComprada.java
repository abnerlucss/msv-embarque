package com.example.abnerlucss.msvvalidationboarding.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "passagem_comprada")
public class PassagemComprada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passagem")
    private Integer idPassagemComprada;

    @Column(name = "nome_passageiro")
    private String nomePassageiro;

    @Column(name = "cpf")
    private String cpfPassageiro;

    @Column(name = "codigo_localizador")
    private String codigoLocalizador;

    @ManyToOne
    @JoinColumn(name = "id_embarque")
    private Embarque embarque;

    public PassagemComprada(String nomePassageiro, String cpfPassageiro, String codigoLocalizador) {
        this.nomePassageiro = nomePassageiro;
        this.cpfPassageiro = cpfPassageiro;
        this.codigoLocalizador = codigoLocalizador;
    }

    public PassagemComprada(String nomePassageiro, String cpfPassageiro, String codigoLocalizador, Embarque embarque) {
        this.nomePassageiro = nomePassageiro;
        this.cpfPassageiro = cpfPassageiro;
        this.codigoLocalizador = codigoLocalizador;
        this.embarque = embarque;
    }
}
