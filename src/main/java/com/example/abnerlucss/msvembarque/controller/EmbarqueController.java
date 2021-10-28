package com.example.abnerlucss.msvembarque.controller;

import com.example.abnerlucss.msvembarque.DTO.EmbarqueDTO;
import com.example.abnerlucss.msvembarque.DTO.MediaEmbarquesDTO;
import com.example.abnerlucss.msvembarque.exception.CreateException;
import com.example.abnerlucss.msvembarque.exception.ListException;
import com.example.abnerlucss.msvembarque.service.EmbarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/embarque")
public class EmbarqueController {

    @Autowired
    private EmbarqueService embarqueService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean cadastrarEmbarque(@RequestBody EmbarqueDTO body) throws CreateException {
        return embarqueService.cadastrarEmbarque(body);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmbarqueDTO> listarEmbarques(){
        return embarqueService.listarEmbarques();
    }

    @GetMapping("embarques/semanais")
    @ResponseStatus(HttpStatus.OK)
    public MediaEmbarquesDTO mediaEmbarquesSemanais(){
        return embarqueService.mediaEmbarquesSemanais();
    }

    @GetMapping("embarques/hoje")
    @ResponseStatus(HttpStatus.OK)
    public Integer embarquePrevistosParaHoje(){
        return embarqueService.embarquePrevistosParaHoje();
    }
}
