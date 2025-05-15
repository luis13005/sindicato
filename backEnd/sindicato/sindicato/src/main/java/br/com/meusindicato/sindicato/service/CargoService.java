package br.com.meusindicato.sindicato.service;

import br.com.meusindicato.sindicato.dto.CargoDTO;
import br.com.meusindicato.sindicato.model.*;
import br.com.meusindicato.sindicato.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public ResponseEntity<Boolean> cadastrarCargo(CargoDTO cargoDTO) {
        System.out.println(cargoDTO.cargoCodigo());
        System.out.println(cargoDTO.cargoDescricao());
        Cargo cargo = new Cargo(cargoDTO.cargoCodigo(),cargoDTO.cargoDescricao());

        cargoRepository.save(cargo);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
