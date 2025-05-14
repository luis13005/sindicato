package br.com.meusindicato.sindicato.dto;

import br.com.meusindicato.sindicato.model.Cidade;
import br.com.meusindicato.sindicato.model.Pais;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EstadoDTO(Long estadoId,
                        @JsonAlias("nome") String estadoNome,
                        @JsonAlias("sigla") String UF,
                         Long paisId){
}