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
import java.time.LocalTime;
import java.util.List;


@RequiredArgsConstructor
@Service
@SuppressWarnings("unused")
public class VooService {

    LocalTime hrInicialEmbarqueCadastrado;
    LocalTime hrFinalEmbarqueCadastrado;

    boolean conflitoHorario;

    @Autowired
    private VooRepository vooRepository;

    @Autowired
    private VooMapper vooMapper;

    @Autowired
    private PortaoRepository portaoRepository;

    @Autowired
    private MsvPassagemService msvPassagemService;

    public VooDTO cadastrarVoo(VooDTO body) throws NotFoundException, CreateException {
        conflitoHorario = false;

        LocalTime horaInicialEmbarque = body.getDataHoraEmbarque().toLocalTime();
        LocalTime horaFinalEmbarque = horaInicialEmbarque.plusMinutes(90);

        validarPortao(body);

        LocalDate dataEmbarque = body.getDataHoraEmbarque().toLocalDate();

        List<Voo> vooLista = vooRepository.buscarVooPorDiaPortao(dataEmbarque, body.getIdPortao(), body.getPartida(), body.getAeroporto());

        if (!vooLista.isEmpty()) {

            vooLista.forEach(voo -> {
                hrInicialEmbarqueCadastrado = voo.getDataHoraEmbarque().toLocalTime();
                hrFinalEmbarqueCadastrado = hrInicialEmbarqueCadastrado.plusMinutes(90);

                if (!horaInicialEmbarque.isBefore(hrInicialEmbarqueCadastrado) && !horaInicialEmbarque.isAfter(hrFinalEmbarqueCadastrado)) {
                    conflitoHorario = true;
                }

                if (!horaFinalEmbarque.isBefore(hrInicialEmbarqueCadastrado) && !horaFinalEmbarque.isAfter(hrInicialEmbarqueCadastrado)) {
                    conflitoHorario = true;
                }

            });
        }

        if (conflitoHorario) {
            throw new CreateException("O portão " + body.getIdPortao() + " está indisponível para esse dia e horário");
        }

        try {
            Voo voo = vooMapper.converteDTOParaEntidade(body);


            Voo save = vooRepository.save(voo);

            msvPassagemService.cadastrarPassagens(vooMapper.converteEntidadeParaDTO(save));

            return vooMapper.converteEntidadeParaDTO(save);
        } catch (Exception e) {
            throw new CreateException("Não foi possível cadastrar o voo");
        }


    }

    private void validarPortao(VooDTO body) throws NotFoundException, CreateException {
        if (!portaoRepository.findById(body.getIdPortao()).isPresent()) {
            throw new NotFoundException("Portão não encontrado");
        }
        if (portaoRepository.findById(body.getIdPortao()).get().getStatus().equals("inativo")) {
            throw new CreateException("Portão inativo");
        }
    }

}
