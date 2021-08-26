package com.example.abnerlucss.msvembarque.services;

import com.example.abnerlucss.msvembarque.DTO.VooDTO;
import com.example.abnerlucss.msvembarque.mapper.VooMapper;
import com.example.abnerlucss.msvembarque.models.Voo;
import com.example.abnerlucss.msvembarque.repositories.PortaoRepository;
import com.example.abnerlucss.msvembarque.repositories.VooRepository;
import javassist.NotFoundException;
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

    public VooDTO cadastrarVoo(VooDTO body) throws NotFoundException {

        LocalDateTime horaInicialEmbarque = body.getDataHoraEmbarque();
        LocalDateTime horaFinalEmbarque = body.getDataHoraEmbarque().plusMinutes(90);

        validarPortao(body);

        LocalDate dataEmbarque = body.getDataHoraEmbarque().toLocalDate();

        List<Voo> vooLista = vooRepository.buscarVooPorDiaPortao(dataEmbarque, body.getIdPortao());

        System.out.println(dataEmbarque);

        System.out.println(vooLista);

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
            System.out.println("O portão está ocupado nesse horário");
            return null;
        } else {
            msvPassagemService.cadastrarPassagens(body);

            Voo voo = vooMapper.converteDTOParaEntidade(body);

            Voo save = vooRepository.save(voo);

            return vooMapper.converteEntidadeParaDTO(save);
        }
    }

    private void validarPortao(VooDTO body) throws NotFoundException {
        if(!portaoRepository.findById(body.getIdPortao()).isPresent()){
            throw new NotFoundException("Portão não encontrado");
        }
    }

}
