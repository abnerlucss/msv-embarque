package com.example.abnerlucss.msvvalidationboarding.mapper;

import com.example.abnerlucss.msvvalidationboarding.DTO.PassagemCompradaDTO;
import com.example.abnerlucss.msvvalidationboarding.models.Embarque;
import com.example.abnerlucss.msvvalidationboarding.models.PassagemComprada;
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
