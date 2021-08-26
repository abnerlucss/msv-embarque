package com.example.abnerlucss.msvembarque.controller;

import com.example.abnerlucss.msvembarque.DTO.EmbarqueDTO;
import com.example.abnerlucss.msvembarque.exception.CreateException;
import com.example.abnerlucss.msvembarque.service.EmbarqueService;
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
    public boolean cadastrarEmbarque(@RequestBody EmbarqueDTO body) throws CreateException {
        return embarqueService.cadastrarEmbarque(body);
    }
}
