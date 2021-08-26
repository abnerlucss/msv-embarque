package com.example.abnerlucss.msvembarque.controllers;

import com.example.abnerlucss.msvembarque.DTO.EmbarqueDTO;
import com.example.abnerlucss.msvembarque.services.EmbarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/embarque")
public class EmbarqueController {

    @Autowired
    private EmbarqueService embarqueService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean cadastrarEmbarque(@RequestBody EmbarqueDTO body){
        return embarqueService.cadastrarEmbarque(body);
    }
}
