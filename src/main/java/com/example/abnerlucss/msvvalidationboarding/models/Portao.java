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
@Table(name = "portao")
public class Portao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_portao")
    private Integer idPortao;

    @Column(name = "numero_portao")
    private Integer numeroPortao;

    @Column(name = "apelido")
    private String apelido;

    @Column(name = "status")
    private String status;

    public Portao(Integer numeroPortao, String apelido, String status) {
        this.numeroPortao = numeroPortao;
        this.apelido = apelido;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Portao{" +
                "idPortao=" + idPortao +
                ", numeroPortao=" + numeroPortao +
                ", apelido='" + apelido + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
