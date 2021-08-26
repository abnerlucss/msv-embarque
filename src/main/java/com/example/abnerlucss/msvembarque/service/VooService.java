package com.example.abnerlucss.msvembarque.service;

import com.example.abnerlucss.msvembarque.DTO.VooDTO;
import com.example.abnerlucss.msvembarque.exception.CreateException;
import com.example.abnerlucss.msvembarque.exception.NotFoundException;
import com.example.abnerlucss.msvembarque.mapper.VooMapper;
import com.example.abnerlucss.msvembarque.model.Voo;
import com.example.abnerlucss.msvembarque.repository.PortaoRepository;
import com.example.abnerlucss.msvembarque.repository.VooRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@Service
@SuppressWarnings("unused")
public class VooService {

    boolean conflitoHorario = false;

    @Autowired
    private VooRepository vooRepository;

    @Autowired
    private VooMapper vooMapper;

    @Autowired
    private PortaoRepository portaoRepository;

    @Autowired
    private MsvPassagemService msvPassagemService;

    public VooDTO cadastrarVoo(VooDTO body) throws NotFoundException, CreateException {

        LocalDateTime horaInicialEmbarque = body.getDataHoraEmbarque();
        LocalDateTime horaFinalEmbarque = body.getDataHoraEmbarque().plusMinutes(90);

        validarPortao(body);

        LocalDate dataEmbarque = body.getDataHoraEmbarque().toLocalDate();

        List<Voo> vooLista = vooRepository.buscarVooPorDiaPortao(dataEmbarque, body.getIdPortao());

        if (!vooLista.isEmpty()) {

            vooLista.stream().forEach(voo -> {

                LocalDateTime vHoraInicialEmbarque = voo.getDataHoraEmbarque();
                LocalDateTime vHoraFinalEmbarque = vHoraInicialEmbarque.plusMinutes(90);

                if (!horaInicialEmbarque.isBefore(vHoraInicialEmbarque) && !horaInicialEmbarque.isAfter(vHoraFinalEmbarque)) {
                    conflitoHorario = true;
                }

                if (!horaFinalEmbarque.isBefore(vHoraInicialEmbarque) && !horaFinalEmbarque.isAfter(vHoraFinalEmbarque)) {
                    conflitoHorario = true;
                }

            });
        }

        if (conflitoHorario) {
            throw new CreateException("O portão " + body.getIdPortao() + " está indisponível para esse dia e horário");
        } else {
            try {
                msvPassagemService.cadastrarPassagens(body);

                Voo voo = vooMapper.converteDTOParaEntidade(body);

                Voo save = vooRepository.save(voo);

                return vooMapper.converteEntidadeParaDTO(save);
            } catch (Exception e) {
                throw new CreateException("Não foi possível cadastrar o voo");
            }
        }
    }

    private void validarPortao(VooDTO body) throws NotFoundException {
        if (!portaoRepository.findById(body.getIdPortao()).isPresent()) {
            throw new NotFoundException("Portão não encontrado");
        }
    }

}
