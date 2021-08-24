package com.example.abnerlucss.msvvalidationboarding.services;

import com.example.abnerlucss.msvvalidationboarding.DTO.VooDTO;
import com.example.abnerlucss.msvvalidationboarding.mapper.VooMapper;
import com.example.abnerlucss.msvvalidationboarding.models.Portao;
import com.example.abnerlucss.msvvalidationboarding.repositories.PortaoRepository;
import com.example.abnerlucss.msvvalidationboarding.repositories.VooRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class VooService {

    @Autowired
    private VooRepository vooRepository;

    @Autowired
    private VooMapper vooMapper;

    @Autowired
    private PortaoRepository portaoRepository;

    @Autowired
    private MsvPassagemService msvPassagemService;

    public VooDTO cadastrarVoo(VooDTO body) {

        Portao portao = portaoRepository.findById(body.getIdPortao()).orElse(null);

        msvPassagemService.cadastrarVoos(body);


        return vooMapper.converteEntidadeParaDTO(vooRepository.save(vooMapper.converteDTOParaEntidade(body, portao)));


    }

}
