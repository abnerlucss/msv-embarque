package com.example.abnerlucss.msvembarque.mapper;

import com.example.abnerlucss.msvembarque.DTO.PortaoDTO;
import com.example.abnerlucss.msvembarque.model.Portao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PortaoMapper {

    public List<PortaoDTO> converteListaEntidadeParaDTO(List<Portao> portaoLista) {

        return portaoLista.stream().map(portao -> PortaoDTO.builder()
                .idPortao(portao.getIdPortao())
                .numero(portao.getNumeroPortao())
                .apelido(portao.getApelido())
                .status(portao.getStatus())
                .build()
        ).collect(Collectors.toList());

    }

    public Portao converteDTOParaEntidade(PortaoDTO portaoDTO) {
        return new Portao(
                portaoDTO.getIdPortao(),
                portaoDTO.getNumero(),
                portaoDTO.getApelido(),
                portaoDTO.getStatus()
        );
    }

    public PortaoDTO converteEntidadeParaDTO(Portao portao) {
        return new PortaoDTO(
                portao.getIdPortao(),
                portao.getNumeroPortao(),
                portao.getApelido(),
                portao.getStatus()
        );
    }

}
