package com.example.abnerlucss.msvembarque.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PortaoDTO {
    private Integer idPortao;
    private Integer numero;
    private String apelido;
    private String status;

    public PortaoDTO(Integer numero, String apelido, String status) {
        this.numero = numero;
        this.apelido = apelido;
        this.status = status;
    }

    public PortaoDTO(Integer numero, String status) {
        this.numero = numero;
        this.status = status;
    }
}
