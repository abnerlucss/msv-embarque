package com.example.abnerlucss.msvvalidationboarding.mapper;

import com.example.abnerlucss.msvvalidationboarding.DTO.EmbarqueDTO;
import com.example.abnerlucss.msvvalidationboarding.models.Embarque;
import com.example.abnerlucss.msvvalidationboarding.models.Voo;
import org.springframework.stereotype.Component;

@Component
public class EmbarqueMapper {

    public Embarque converteDTOParaEntidade(EmbarqueDTO embarqueDTO, Voo voo) {
        return new Embarque(
                embarqueDTO.getDataHoraEmbarque(),
                embarqueDTO.getClasse(),
                embarqueDTO.getCodigoLocalizador(),
                embarqueDTO.getIdentificadorComp(),
                embarqueDTO.getNumeroAssento(),
                voo,
                embarqueDTO.getDestino()
        );
    }

}
