package br.com.meusindicato.sindicato.controller;

import br.com.meusindicato.sindicato.dto.CargoClasseDTO;
import br.com.meusindicato.sindicato.dto.CargoDTO;
import br.com.meusindicato.sindicato.dto.NivelDTO;
import br.com.meusindicato.sindicato.model.CargoClasse;
import br.com.meusindicato.sindicato.model.Nivel;
import br.com.meusindicato.sindicato.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.StyledEditorKit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    CargoService cargoService;

    @PostMapping("/cargo")
    public ResponseEntity<Boolean> cadastrarCargo(@RequestBody CargoDTO cargoDTO){

        return cargoService.cadastrarCargo(cargoDTO);
    }
}
