package com.example.abnerlucss.msvembarque.mapper;

import com.example.abnerlucss.msvembarque.DTO.EmbarqueDTO;
import com.example.abnerlucss.msvembarque.models.Embarque;
import com.example.abnerlucss.msvembarque.models.Voo;
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
