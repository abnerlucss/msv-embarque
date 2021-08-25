package com.example.abnerlucss.msvvalidationboarding.mapper;

import com.example.abnerlucss.msvvalidationboarding.DTO.CartaoEmbarqueDTO;
import com.example.abnerlucss.msvvalidationboarding.models.Embarque;
import org.springframework.stereotype.Component;

@Component
public class CartaoEmbarqueMapper {
    public CartaoEmbarqueDTO gerarCartaoEmbarque(Embarque embarque) {
        return new CartaoEmbarqueDTO(
                embarque.getDataHoraEmbarque(),
                embarque.getClasse(),
                embarque.getIdentificadorComp(),
                embarque.getNumeroAssento(),
                embarque.getVoo().getPortao().getNumeroPortao(),
                embarque.getDestino()
        );
    }
}
