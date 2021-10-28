package com.example.abnerlucss.msvembarque.service;

import com.example.abnerlucss.msvembarque.DTO.EmbarqueDTO;
import com.example.abnerlucss.msvembarque.DTO.MediaEmbarquesDTO;
import com.example.abnerlucss.msvembarque.exception.CreateException;
import com.example.abnerlucss.msvembarque.mapper.EmbarqueMapper;
import com.example.abnerlucss.msvembarque.model.Voo;
import com.example.abnerlucss.msvembarque.repository.EmbarqueRepository;
import com.example.abnerlucss.msvembarque.repository.VooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmbarqueService {
    @Autowired
    private EmbarqueRepository embarqueRepository;

    @Autowired
    private EmbarqueMapper embarqueMapper;

    @Autowired
    private VooRepository vooRepository;

    public boolean cadastrarEmbarque(EmbarqueDTO body) throws CreateException {
        try {

            Optional<Voo> voo = vooRepository.findByParams(body.getDataHoraEmbarque(), body.getIdentificadorComp(), body.getDestino(), body.getPartida(), body.getAeroporto(), body.getIdVoo());

            embarqueRepository.save(embarqueMapper.converteDTOParaEntidade(body, voo.get()));

            return true;

        } catch (Exception e) {
            throw new CreateException("Erro ao cadastrar embarque");
        }
    }

    public List<EmbarqueDTO> listarEmbarques() {
        return embarqueMapper.converteListaEntidadeParaDTO(embarqueRepository.findAll());
    }

    public MediaEmbarquesDTO mediaEmbarquesSemanais(){
        return new MediaEmbarquesDTO(
                1765,
                1432,
                1235,
                1653,
                1809,
                1976,
                1704
        );
    }

    public Integer embarquePrevistosParaHoje(){
        return embarqueRepository.embarquePrevistosParaHoje();
    }
}
