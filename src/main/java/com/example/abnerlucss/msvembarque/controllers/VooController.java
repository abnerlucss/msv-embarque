package com.example.abnerlucss.msvembarque.controllers;

import com.example.abnerlucss.msvembarque.DTO.VooDTO;
import com.example.abnerlucss.msvembarque.services.VooService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("v1/voo")
public class VooController {
    @Autowired
    private VooService vooService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VooDTO cadastrarVoo(@RequestBody VooDTO body) throws NotFoundException {
        return vooService.cadastrarVoo(body);
    }
}
