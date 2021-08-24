package com.example.abnerlucss.msvvalidationboarding.services;

import com.example.abnerlucss.msvvalidationboarding.DTO.CartaoEmbarqueDTO;
import com.example.abnerlucss.msvvalidationboarding.DTO.PassagemCompradaDTO;
import com.example.abnerlucss.msvvalidationboarding.mapper.CartaoEmbarqueMapper;
import com.example.abnerlucss.msvvalidationboarding.mapper.PassagemCompradaMapper;
import com.example.abnerlucss.msvvalidationboarding.models.Embarque;
import com.example.abnerlucss.msvvalidationboarding.repositories.EmbarqueRepository;
import com.example.abnerlucss.msvvalidationboarding.repositories.PassagemCompradaRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidacaoService {
    @Autowired
    private PassagemCompradaRepository passagemCompradaRepository;

    @Autowired
    private EmbarqueRepository embarqueRepository;

    @Autowired
    private PassagemCompradaMapper passagemCompradaMapper;

    @Autowired
    private CartaoEmbarqueMapper cartaoEmbarqueMapper;

    public CartaoEmbarqueDTO validarEmbarque(PassagemCompradaDTO body) throws NotFoundException {
        Optional<Embarque> embarque = embarqueRepository.findByCodigoLocalizador(body.getCodigoLocalizador());

        if (embarque.isPresent()) {
            passagemCompradaRepository.save(passagemCompradaMapper.converteDTOParaEntidade(body, embarque.get()));
            return cartaoEmbarqueMapper.gerarCartaoEmbarque(embarque.get());
        }
        else{
            throw new NotFoundException("codigo localizador não encontrado");
        }
    }
}
