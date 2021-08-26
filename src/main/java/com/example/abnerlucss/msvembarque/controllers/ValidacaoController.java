package com.example.abnerlucss.msvembarque.controllers;

import com.example.abnerlucss.msvembarque.DTO.CartaoEmbarqueDTO;
import com.example.abnerlucss.msvembarque.DTO.PassagemCompradaDTO;
import com.example.abnerlucss.msvembarque.services.ValidacaoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/validacao")
public class ValidacaoController {

    @Autowired
    private ValidacaoService validacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CartaoEmbarqueDTO validarEmbarque(@RequestBody PassagemCompradaDTO body) throws NotFoundException {
        return validacaoService.validarEmbarque(body);
    }
}