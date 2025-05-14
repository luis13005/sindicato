package br.com.meusindicato.sindicato.service;

import br.com.meusindicato.sindicato.dto.PaisDTO;
import br.com.meusindicato.sindicato.model.Pais;
import br.com.meusindicato.sindicato.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public ResponseEntity<Boolean> inserirPais(PaisDTO paisDTO) {
        Pais pais = new Pais(paisDTO.nome(),paisDTO.sigla());
        Pais paisSalvo = paisRepository.save(pais);
        PaisDTO novopais = new PaisDTO(paisSalvo.getPaisId(),paisSalvo.getNomePais(),paisSalvo.getSiglaPais());

        System.out.println(novopais);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    public List<PaisDTO> listaPaises() {

        return null;
    }
}