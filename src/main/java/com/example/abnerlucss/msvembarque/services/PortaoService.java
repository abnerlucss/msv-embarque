package com.example.abnerlucss.msvembarque.services;

import com.example.abnerlucss.msvembarque.DTO.PortaoDTO;
import com.example.abnerlucss.msvembarque.mapper.PortaoMapper;
import com.example.abnerlucss.msvembarque.models.Portao;
import com.example.abnerlucss.msvembarque.repositories.PortaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortaoService {

    @Autowired
    private PortaoRepository portaoRepository;

    @Autowired
    private PortaoMapper portaoMapper;

    public List<PortaoDTO> listarTodosPortoes(){
        return portaoMapper.converteListaEntidadeParaDTO(portaoRepository.findAll());
    }

    public PortaoDTO cadastrarPortao(PortaoDTO body) {
        Portao portao = portaoRepository.save(portaoMapper.converteDTOParaEntidade(body));
        return portaoMapper.converteEntidadeParaDTO(portao);
    }

    public PortaoDTO atualizarPortao(Integer id, PortaoDTO body){
        Portao portao = portaoRepository.getById(id);
        if(portao == null)
            return null;

        portao.setNumeroPortao(body.getNumero());
        portao.setApelido(body.getApelido());
        portao.setStatus(body.getStatus());

        return portaoMapper.converteEntidadeParaDTO(portaoRepository.save(portao));
    }

    public String excluirPortaoPorId(Integer id) {
        Portao portao = portaoRepository.findById(id).orElse(null);
        if (portao == null)
            return "Portão não encontrado";

        portaoRepository.delete(portao);
        return "Portao " + portao.getNumeroPortao() + " excluído com sucesso";
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

    public PortaoDTO buscarPortaoPorId(Integer id) {
        return portaoMapper.converteEntidadeParaDTO(portaoRepository.findById(id).orElse(null));
    }
}
