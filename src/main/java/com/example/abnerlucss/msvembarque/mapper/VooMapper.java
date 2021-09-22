package com.example.abnerlucss.msvembarque.mapper;

import com.example.abnerlucss.msvembarque.DTO.VooDTO;
import com.example.abnerlucss.msvembarque.model.Portao;
import com.example.abnerlucss.msvembarque.model.Voo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VooMapper {

    public Voo converteDTOParaEntidade(VooDTO vooDTO) {

        return new Voo(
                vooDTO.getIdVoo(),
                vooDTO.getPartida(),
                vooDTO.getAeroporto(),
                vooDTO.getDataHoraEmbarque(),
                vooDTO.getDataHoraDesembarque(),
                vooDTO.getDestino(),
                vooDTO.getIdentificadorCompanhia(),
                vooDTO.getQtdEconomica(),
                vooDTO.getQtdExecutiva(),
                vooDTO.getQtdPrimeiraClasse(),
                vooDTO.getStatus(),
                vooDTO.getPrecoPrimeiraClasse(),
                vooDTO.getPrecoExecutiva(),
                vooDTO.getPrecoEconomica(),
                Portao.builder().idPortao(vooDTO.getIdPortao()).build()
        );
    }

    public VooDTO converteEntidadeParaDTO(Voo voo) {
        return new VooDTO(
                voo.getIdVoo(),
                voo.getPartida(),
                voo.getAeroporto(),
                voo.getDataHoraEmbarque(),
                voo.getDataHoraDesembarque(),
                voo.getDestino(),
                voo.getIdentificadorCompanhia(),
                voo.getQtdEconomica(),
                voo.getQtdExecutiva(),
                voo.getQtdPrimeiraClasse(),
                voo.getStatus(),
                voo.getPrecoPrimeiraClasse(),
                voo.getPrecoExecutiva(),
                voo.getPrecoEconomica(),
                voo.getPortao().getIdPortao()
        );
    }

    public List<VooDTO> converteListaEntidadeParaDTO(List<Voo> vooLista) {
        return vooLista.stream().map(voo -> VooDTO.builder()
                .idVoo(voo.getIdVoo())
                .aeroporto(voo.getAeroporto())
                .dataHoraEmbarque(voo.getDataHoraEmbarque())
                .dataHoraDesembarque(voo.getDataHoraDesembarque())
                .destino(voo.getDestino())
                .identificadorCompanhia(voo.getIdentificadorCompanhia())
                .qtdEconomica(voo.getQtdEconomica())
                .qtdExecutiva(voo.getQtdExecutiva())
                .qtdPrimeiraClasse(voo.getQtdPrimeiraClasse())
                .status(voo.getStatus())
                .idPortao(voo.getPortao().getIdPortao())
                .precoPrimeiraClasse(voo.getPrecoPrimeiraClasse())
                .precoExecutiva(voo.getPrecoExecutiva())
                .precoEconomica(voo.getPrecoEconomica())
                .partida(voo.getPartida())
                .build()
        ).collect(Collectors.toList());
    }

}
