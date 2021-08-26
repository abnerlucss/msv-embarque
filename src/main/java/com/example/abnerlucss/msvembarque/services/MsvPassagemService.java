package com.example.abnerlucss.msvembarque.services;

import com.example.abnerlucss.msvembarque.DTO.PassagemDTO;
import com.example.abnerlucss.msvembarque.DTO.VooDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "embarque", url = "http://localhost:8080/v1/passagem")
public interface MsvPassagemService {

    @RequestMapping(method = RequestMethod.POST, value = "/")
    List<PassagemDTO> cadastrarPassagens(@RequestBody VooDTO vooDTO);
}
