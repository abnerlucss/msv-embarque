package com.example.abnerlucss.msvembarque.mapper;

import com.example.abnerlucss.msvembarque.DTO.VooDTO;
import com.example.abnerlucss.msvembarque.model.Portao;
import com.example.abnerlucss.msvembarque.model.Voo;
import org.springframework.stereotype.Component;

@Component
public class VooMapper {

    public Voo converteDTOParaEntidade(VooDTO vooDTO){

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

    public VooDTO converteEntidadeParaDTO(Voo voo){
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

}
