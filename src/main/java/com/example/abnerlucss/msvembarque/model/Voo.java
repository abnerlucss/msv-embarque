package com.example.abnerlucss.msvembarque.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "partida")
    private String partida;

    @Column(name = "aeroporto")
    private String aeroporto;

    @Column(name = "data_hora_embarque")
    private LocalDateTime dataHoraEmbarque;

    @Column(name = "data_hora_desembarque")
    private LocalDateTime dataHoraDesembarque;

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

    @Column(name = "preco_primeira_classe")
    private Double precoPrimeiraClasse;

    @Column(name = "preco_executiva")
    private Double precoExecutiva;

    @Column(name = "preco_economica")
    private Double precoEconomica;

    @ManyToOne
    @JoinColumn(name = "id_portao")
    private Portao portao;

    @Override
    public String toString() {
        return "Voo{" +
                "idVoo=" + idVoo +
                ", partida='" + partida + '\'' +
                ", aeroporto='" + aeroporto + '\'' +
                ", dataHoraEmbarque=" + dataHoraEmbarque +
                ", dataHoraDesembarque=" + dataHoraDesembarque +
                ", destino='" + destino + '\'' +
                ", identificadorCompanhia='" + identificadorCompanhia + '\'' +
                ", qtdEconomica=" + qtdEconomica +
                ", qtdExecutiva=" + qtdExecutiva +
                ", qtdPrimeiraClasse=" + qtdPrimeiraClasse +
                ", status='" + status + '\'' +
                ", precoPrimeiraClasse=" + precoPrimeiraClasse +
                ", precoExecutiva=" + precoExecutiva +
                ", precoEconomica=" + precoEconomica +
                ", portao=" + portao +
                '}';
    }
}
