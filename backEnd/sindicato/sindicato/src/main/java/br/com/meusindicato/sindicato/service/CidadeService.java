package br.com.meusindicato.sindicato.service;

import br.com.meusindicato.sindicato.dto.CidadeDTO;
import br.com.meusindicato.sindicato.dto.EstadoDTO;
import br.com.meusindicato.sindicato.model.Cidade;
import br.com.meusindicato.sindicato.model.Estado;
import br.com.meusindicato.sindicato.repository.CidadeRepository;
import br.com.meusindicato.sindicato.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public ResponseEntity<Boolean> cadastraCidade(CidadeDTO cidadeDTO) {
        System.out.println("CIDADEDTO SERVICE: "+cidadeDTO);
        Optional<Estado> estado = estadoRepository.findById(cidadeDTO.estadoId());

        if (estado.isPresent()){
            System.out.println("NOME CIDADE: "+cidadeDTO.cidadeNome());
            System.out.println("ESTADO: "+estado.get());
            Cidade cidade = new Cidade(cidadeDTO.cidadeNome(),estado.get());

            cidadeRepository.save(cidade);

            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(true, HttpStatus.BAD_REQUEST);
    }

    public List<EstadoDTO> buscaEstados() {
        List<Estado> estadoList = estadoRepository.findAll();
            return converteEstado(estadoList);
    }

    public List<EstadoDTO> converteEstado(List<Estado> estadoList){
        return estadoList.stream()
                .map(e -> new EstadoDTO(e.getEstadoId(),e.getEstadoNome(),e.getUF(),e.getPais().getPaisId()))
                .collect(Collectors.toList());
    }
}
