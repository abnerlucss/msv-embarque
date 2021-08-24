package com.example.abnerlucss.msvvalidationboarding.mapper;

import com.example.abnerlucss.msvvalidationboarding.DTO.VooDTO;
import com.example.abnerlucss.msvvalidationboarding.models.Portao;
import com.example.abnerlucss.msvvalidationboarding.models.Voo;
import org.springframework.stereotype.Component;

@Component
public class VooMapper {

    public Voo converteDTOParaEntidade(VooDTO vooDTO, Portao portao){
        return new Voo(
                vooDTO.getAeroporto(),
                vooDTO.getDataEmbarque(),
                vooDTO.getHoraEmbarque(),
                vooDTO.getHoraDesembarque(),
                vooDTO.getDestino(),
                vooDTO.getIdentificadorCompanhia(),
                vooDTO.getQtdEconomica(),
                vooDTO.getQtdExecutiva(),
                vooDTO.getQtdPrimeiraClasse(),
                vooDTO.getStatus(),
                portao
        );
    }

    public VooDTO converteEntidadeParaDTO(Voo voo){
        return new VooDTO(
                voo.getIdVoo(),
                voo.getAeroporto(),
                voo.getDataEmbarque(),
                voo.getHoraEmbarque(),
                voo.getHoraDesembarque(),
                voo.getDestino(),
                voo.getIdentificadorCompanhia(),
                voo.getQtdEconomica(),
                voo.getQtdExecutiva(),
                voo.getQtdPrimeiraClasse(),
                voo.getStatus(),
                voo.getPortao().getIdPortao()
        );
    }

}
