package br.com.meusindicato.sindicato.controller;

import br.com.meusindicato.sindicato.dto.CidadeDTO;
import br.com.meusindicato.sindicato.dto.EstadoDTO;
import br.com.meusindicato.sindicato.repository.EstadoRepository;
import br.com.meusindicato.sindicato.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/buscaestados")
    public List<EstadoDTO> estados(){
        return cidadeService.buscaEstados();
    }

    @PostMapping("/cidade")
    public ResponseEntity<Boolean> cadastraCidade(@RequestBody CidadeDTO cidadeDTO){
        System.out.println("CIDADEDTO CONTROLLER: "+cidadeDTO);
        return cidadeService.cadastraCidade(cidadeDTO);
    }
}
