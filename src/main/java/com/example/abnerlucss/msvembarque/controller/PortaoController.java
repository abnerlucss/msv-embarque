package com.example.abnerlucss.msvembarque.controller;

import com.example.abnerlucss.msvembarque.DTO.PortaoDTO;
import com.example.abnerlucss.msvembarque.exception.CreateException;
import com.example.abnerlucss.msvembarque.exception.DeleteException;
import com.example.abnerlucss.msvembarque.exception.NotFoundException;
import com.example.abnerlucss.msvembarque.exception.UpdateException;
import com.example.abnerlucss.msvembarque.service.PortaoService;
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
    public PortaoDTO cadastrarPortao(@RequestBody PortaoDTO body) throws CreateException {
        return portaoService.cadastrarPortao(body);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PortaoDTO cadastrarPortao(@PathVariable Integer id, @RequestBody PortaoDTO body) throws UpdateException, NotFoundException {
        return portaoService.atualizarPortao(id, body);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String excluirPortaoPorId(@PathVariable Integer id) throws NotFoundException, DeleteException {
        return portaoService.excluirPortaoPorId(id);
    }

    @GetMapping("/ativos")
    @ResponseStatus(HttpStatus.OK)
    public List<PortaoDTO> listarPortoesDisponiveis(){
        return portaoService.listarPortoesDisponiveis();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/inativos")
    @ResponseStatus(HttpStatus.OK)
    public List<PortaoDTO> listarPortoesIndisponiveis(){
        return portaoService.listarPortoesIndisponiveis();
    }

    @GetMapping("/id/{id}")
    public PortaoDTO buscarPortaoPorId(@PathVariable Integer id) throws NotFoundException {
        return portaoService.buscarPortaoPorId(id);
    }


}
