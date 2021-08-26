package com.example.abnerlucss.msvembarque.service;

import com.example.abnerlucss.msvembarque.DTO.CartaoEmbarqueDTO;
import com.example.abnerlucss.msvembarque.DTO.PassagemCompradaDTO;
import com.example.abnerlucss.msvembarque.exception.NotFoundException;
import com.example.abnerlucss.msvembarque.mapper.CartaoEmbarqueMapper;
import com.example.abnerlucss.msvembarque.mapper.PassagemCompradaMapper;
import com.example.abnerlucss.msvembarque.model.Embarque;
import com.example.abnerlucss.msvembarque.repository.EmbarqueRepository;
import com.example.abnerlucss.msvembarque.repository.PassagemCompradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@SuppressWarnings("unused")
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
        } else {
            throw new NotFoundException("Embarque não encontrado");
        }
    }
}
