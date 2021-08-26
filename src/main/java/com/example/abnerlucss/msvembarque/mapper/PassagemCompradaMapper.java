package com.example.abnerlucss.msvembarque.mapper;

import com.example.abnerlucss.msvembarque.DTO.PassagemCompradaDTO;
import com.example.abnerlucss.msvembarque.models.Embarque;
import com.example.abnerlucss.msvembarque.models.PassagemComprada;
import org.springframework.stereotype.Component;

@Component
public class PassagemCompradaMapper {
    public PassagemComprada converteDTOParaEntidade(PassagemCompradaDTO passagemCompradaDTO, Embarque embarque){
        return new PassagemComprada(
                passagemCompradaDTO.getNomePassageiro(),
                passagemCompradaDTO.getCpfPassageiro(),
                passagemCompradaDTO.getCodigoLocalizador(),
                embarque
        );
    }

}
