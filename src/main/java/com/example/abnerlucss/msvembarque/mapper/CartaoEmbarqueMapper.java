package com.example.abnerlucss.msvembarque.mapper;

import com.example.abnerlucss.msvembarque.DTO.CartaoEmbarqueDTO;
import com.example.abnerlucss.msvembarque.model.Embarque;
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
