package br.com.meusindicato.sindicato.service;

import br.com.meusindicato.sindicato.dto.*;
import br.com.meusindicato.sindicato.model.*;
import br.com.meusindicato.sindicato.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private FormacaoRepository formacaoRepository;

    @Autowired
    private LotacaoRepository lotacaoRepository;

    public List<PaisDTO> listaPaises() {

        List<Pais> paisList = paisRepository.findByOrderByNomePais();

        return paisList.stream()
                .map(p -> new PaisDTO(p.getPaisId(),p.getNomePais(),p.getSiglaPais()))
                .collect(Collectors.toList());
    }

    public List<EstadoDTO> listaEstados(Long paisId) {

            Optional<Pais> paisOptional = paisRepository.findById(paisId);
            if (paisOptional.isPresent()){
                return converteEstado(estadoRepository.findByPais(paisOptional.get()));
            }
            return null;
    }

    public List<CidadeDTO> listaCidades(Long estadoId) {


        Optional<Estado> estadoOptional = estadoRepository.findById(estadoId);
        if (estadoOptional.isPresent()){

            return converteCidade(cidadeRepository.findByEstado(estadoOptional.get()));
        }
        return null;
    }

    public static List<EstadoDTO> converteEstado(List<Estado> estados){

        return estados.stream()
                .map(e -> new EstadoDTO(e.getEstadoId(),e.getEstadoNome(),e.getUF(),e.getPais().getPaisId()))
                .collect(Collectors.toList());
    }

    public static List<CidadeDTO> converteCidade(List<Cidade> cidades){

        return cidades.stream()
                .map(c -> new CidadeDTO(c.getCidadeId(),c.getCidadeNome(),c.getEstado().getEstadoId()))
                .collect(Collectors.toList());
    }

    public List<FormacaoDTO> listaFormacoes() {
        List<Formacao> formacaoList = formacaoRepository.findByOrderByFormacaoCodigo();
        return formacaoList.stream()
                .map(f -> new FormacaoDTO(f.getFormacaoCodigo(),f.getNomeFormacao()))
                .collect(Collectors.toList());
    }

    public List<LotacaoDTO> listaLotacoes() {
        List<Lotacao> lotacaoList = lotacaoRepository.findByOrderByLotacaoDescricao();
        return lotacaoList.stream().map(
                l -> new LotacaoDTO(l.getLotacaoId(),l.getLotacaoDescricao())
        ).collect(Collectors.toList());
    }
}