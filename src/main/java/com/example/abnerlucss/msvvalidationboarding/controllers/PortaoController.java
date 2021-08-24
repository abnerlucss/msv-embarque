package com.example.abnerlucss.msvvalidationboarding.controllers;

import com.example.abnerlucss.msvvalidationboarding.DTO.PortaoDTO;
import com.example.abnerlucss.msvvalidationboarding.services.PortaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/v1/portao")
public class PortaoController {

    @Autowired
    private PortaoService portaoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PortaoDTO> listarTodosPortoes(){
        return portaoService.listarTodosPortoes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PortaoDTO cadastrarPortao(@RequestBody PortaoDTO body){
        return portaoService.cadastrarPortao(body);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PortaoDTO cadastrarPortao(@PathVariable Integer id, @RequestBody PortaoDTO body){
        return portaoService.atualizarPortao(id, body);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String excluirPortaoPorId(@PathVariable Integer id){
        return portaoService.excluirPortaoPorId(id);
    }

    @GetMapping("/ativos")
    @ResponseStatus(HttpStatus.OK)
    public List<PortaoDTO> listarPortoesDisponiveis(){
        return portaoService.listarPortoesDisponiveis();
    }

    @GetMapping("/inativos")
    @ResponseStatus(HttpStatus.OK)
    public List<PortaoDTO> listarPortoesIndisponiveis(){
        return portaoService.listarPortoesIndisponiveis();
    }

    @GetMapping("/id/{id}")
    public PortaoDTO buscarPortaoPorId(@PathVariable Integer id){
        return portaoService.buscarPortaoPorId(id);
    }


}
