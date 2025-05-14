package br.com.meusindicato.sindicato.controller;

import br.com.meusindicato.sindicato.dto.PaisDTO;
import br.com.meusindicato.sindicato.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @PostMapping("/pais")
    public ResponseEntity<Boolean> cadastrarPais(@RequestBody PaisDTO paisDTO){

        System.out.println("Pais: "+paisDTO);

        return paisService.inserirPais(paisDTO);
    }
}
