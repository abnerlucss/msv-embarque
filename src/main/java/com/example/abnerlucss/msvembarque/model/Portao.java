package com.example.abnerlucss.msvembarque.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
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

}
