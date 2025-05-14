package br.com.meusindicato.sindicato.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CargoDTO( Long cargoId,
                        Integer cargoCodigo,
                        String cargoDescricao,
                        List<PessoaDTO> pessoas) {
}
