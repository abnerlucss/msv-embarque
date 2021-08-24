package com.example.abnerlucss.msvvalidationboarding.services;

import com.example.abnerlucss.msvvalidationboarding.DTO.PassagemDTO;
import com.example.abnerlucss.msvvalidationboarding.DTO.VooDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "embarque", url = "http://localhost:8080/v1/passagem")
public interface MsvPassagemService {

    @RequestMapping(method = RequestMethod.POST, value = "/")
    List<PassagemDTO> cadastrarVoos(@RequestBody VooDTO vooDTO);
}
