package com.example.abnerlucss.msvembarque.mapper;

import com.example.abnerlucss.msvembarque.DTO.EmbarqueDTO;
import com.example.abnerlucss.msvembarque.DTO.VooDTO;
import com.example.abnerlucss.msvembarque.model.Embarque;
import com.example.abnerlucss.msvembarque.model.Voo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<EmbarqueDTO> converteListaEntidadeParaDTO(List<Embarque> embarqueList) {
        return embarqueList.stream().map(embarque -> EmbarqueDTO.builder()
                .idEmbarque(embarque.getIdEmbarque())
                .idVoo(embarque.getVoo().getIdVoo())
                .numeroAssento(embarque.getNumeroAssento())
                .dataHoraEmbarque(embarque.getDataHoraEmbarque())
                .aeroporto(embarque.getVoo().getAeroporto())
                .destino(embarque.getDestino())
                .classe(embarque.getClasse())
                .identificadorComp(embarque.getIdentificadorComp())
                .codigoLocalizador(embarque.getCodigoLocalizador())
                .partida(embarque.getVoo().getPartida())
                .build()).collect(Collectors.toList());
    }
}
