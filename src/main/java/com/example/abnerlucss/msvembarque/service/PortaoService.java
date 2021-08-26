package com.example.abnerlucss.msvembarque.service;

import com.example.abnerlucss.msvembarque.DTO.PortaoDTO;
import com.example.abnerlucss.msvembarque.exception.CreateException;
import com.example.abnerlucss.msvembarque.exception.DeleteException;
import com.example.abnerlucss.msvembarque.exception.NotFoundException;
import com.example.abnerlucss.msvembarque.exception.UpdateException;
import com.example.abnerlucss.msvembarque.mapper.PortaoMapper;
import com.example.abnerlucss.msvembarque.model.Portao;
import com.example.abnerlucss.msvembarque.repository.PortaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortaoService {

    @Autowired
    private PortaoRepository portaoRepository;

    @Autowired
    private PortaoMapper portaoMapper;

    public List<PortaoDTO> listarTodosPortoes() {
        return portaoMapper.converteListaEntidadeParaDTO(portaoRepository.findAll());
    }

    public PortaoDTO cadastrarPortao(PortaoDTO body) throws CreateException {
        try {
            Portao portao = portaoRepository.save(portaoMapper.converteDTOParaEntidade(body));
            return portaoMapper.converteEntidadeParaDTO(portao);
        } catch (Exception e) {
            throw new CreateException("Erro ao cadastrar portão", e.getCause());
        }
    }

    public PortaoDTO atualizarPortao(Integer id, PortaoDTO body) throws UpdateException, NotFoundException {
        Portao portao = portaoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Portão não encontrado!")
        );

        try {
            portao.setNumeroPortao(body.getNumero());
            portao.setApelido(body.getApelido());
            portao.setStatus(body.getStatus());

            return portaoMapper.converteEntidadeParaDTO(portaoRepository.save(portao));
        } catch (Exception e) {
            throw new UpdateException("Falha ao atualizar o portão");
        }
    }

    public String excluirPortaoPorId(Integer id) throws NotFoundException, DeleteException {
        Portao portao = portaoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Portão não encontrado!")
        );
        try {
            portaoRepository.delete(portao);
            return "Portao " + portao.getNumeroPortao() + " excluído com sucesso";
        } catch (Exception e) {
            throw new DeleteException("Erro ao excluír portão " + id, e.getCause());
        }
    }

    public List<PortaoDTO> listarPortoesDisponiveis() {
        return portaoMapper.converteListaEntidadeParaDTO(
                portaoRepository.listarPortoesAtivos()
        );
    }

    public List<PortaoDTO> listarPortoesIndisponiveis() {
        return portaoMapper.converteListaEntidadeParaDTO(
                portaoRepository.listarPortoesInativos()
        );
    }

    public PortaoDTO buscarPortaoPorId(Integer id) throws NotFoundException {
        return portaoMapper.converteEntidadeParaDTO(portaoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Portão não encontrado")
        ));
    }
}
