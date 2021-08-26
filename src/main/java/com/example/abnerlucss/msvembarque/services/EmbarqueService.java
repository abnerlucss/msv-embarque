package com.example.abnerlucss.msvembarque.services;

import com.example.abnerlucss.msvembarque.DTO.EmbarqueDTO;
import com.example.abnerlucss.msvembarque.mapper.EmbarqueMapper;
import com.example.abnerlucss.msvembarque.models.Voo;
import com.example.abnerlucss.msvembarque.repositories.EmbarqueRepository;
import com.example.abnerlucss.msvembarque.repositories.VooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmbarqueService {
    @Autowired
    private EmbarqueRepository embarqueRepository;

    @Autowired
    private EmbarqueMapper embarqueMapper;

    @Autowired
    private VooRepository vooRepository;

    public boolean cadastrarEmbarque(EmbarqueDTO body) {
        Optional<Voo> voo = vooRepository.findByParams(body.getDataHoraEmbarque(),body.getIdentificadorComp(), body.getDestino());

        embarqueRepository.save(embarqueMapper.converteDTOParaEntidade(body, voo.get()));
        return true;
    }

}
