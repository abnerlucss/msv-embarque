package com.example.abnerlucss.msvvalidationboarding.mapper;

import com.example.abnerlucss.msvvalidationboarding.DTO.VooDTO;
import com.example.abnerlucss.msvvalidationboarding.models.Portao;
import com.example.abnerlucss.msvvalidationboarding.models.Voo;
import org.springframework.stereotype.Component;

@Component
public class VooMapper {

    public Voo converteDTOParaEntidade(VooDTO vooDTO){
//        Portao portao = new Portao();
//        portao.setIdPortao(vooDTO.getIdPortao());

        return new Voo(
                vooDTO.getIdVoo(),
                vooDTO.getAeroporto(),
                vooDTO.getDataHoraEmbarque(),
                vooDTO.getDataHoraDesembarque(),
                vooDTO.getDestino(),
                vooDTO.getIdentificadorCompanhia(),
                vooDTO.getQtdEconomica(),
                vooDTO.getQtdExecutiva(),
                vooDTO.getQtdPrimeiraClasse(),
                vooDTO.getStatus(),
                Portao.builder().idPortao(vooDTO.getIdPortao()).build()
        );
    }

    public VooDTO converteEntidadeParaDTO(Voo voo){
        return new VooDTO(
                voo.getIdVoo(),
                voo.getAeroporto(),
                voo.getDataHoraEmbarque(),
                voo.getDataHoraDesembarque(),
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
