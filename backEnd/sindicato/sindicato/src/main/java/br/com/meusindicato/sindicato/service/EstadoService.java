package br.com.meusindicato.sindicato.service;

import br.com.meusindicato.sindicato.dto.EstadoDTO;
import br.com.meusindicato.sindicato.dto.PaisDTO;
import br.com.meusindicato.sindicato.model.Estado;
import br.com.meusindicato.sindicato.model.Pais;
import br.com.meusindicato.sindicato.repository.EstadoRepository;
import br.com.meusindicato.sindicato.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PaisRepository paisRepository;

    public ResponseEntity<Boolean> inserirEstado(EstadoDTO estadoDTO) {
        System.out.println("Estado Nome: "+estadoDTO.estadoNome());
        System.out.println("Estado UF: "+estadoDTO.UF());
        System.out.println("Estado UF: "+estadoDTO.paisId());

        Optional<Pais> pais = paisRepository.findById(estadoDTO.paisId());

        Estado estado = new Estado(estadoDTO.estadoNome(),estadoDTO.UF(),pais.get());
        estadoRepository.save(estado);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    public List<PaisDTO> pegarPaises() {
    return convertePais(paisRepository.findByOrderByNomePais());
    }

    public List<PaisDTO> convertePais(List<Pais> paisList){

        return paisList.stream()
                .map(p -> new PaisDTO(p.getPaisId(),p.getNomePais(),p.getSiglaPais()))
                .collect(Collectors.toList());

    }
}
