package br.com.meusindicato.sindicato.dto;

import br.com.meusindicato.sindicato.model.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FormacaoDTO( Long formacaoId,
        String nomeFormacao,
        Integer codigoFormacao,
        List<Pessoa> formacaoPessoas){
}
