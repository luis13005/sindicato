package br.com.meusindicato.sindicato.controller;

import br.com.meusindicato.sindicato.dto.EstadoDTO;
import br.com.meusindicato.sindicato.dto.PaisDTO;
import br.com.meusindicato.sindicato.model.Pais;
import br.com.meusindicato.sindicato.service.EstadoService;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping("/estado")
    public ResponseEntity<Boolean> cadastrarEstado(@RequestBody EstadoDTO estadoDTO){
        return estadoService.inserirEstado(estadoDTO);
    }

    @GetMapping("/buscapaises")
    public List<PaisDTO> pegarPaises(){
        return estadoService.pegarPaises();
    }
}
