package br.com.meusindicato.sindicato.dto;

import br.com.meusindicato.sindicato.model.CargoClasse;
import br.com.meusindicato.sindicato.model.Nivel;
import br.com.meusindicato.sindicato.model.Sexo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PessoaDTO(Long pessoaId,
                        String nomeCompleto,
                        Integer rg,
                        String orgaoExpedidor,
                        Date dataEmissaoRg,
                        Integer cep,
                        String endereco,
                        String bairro,
                        Long cidadeAtualId,
                        Long cidadeNaturalId,
                        String email,
                        Integer telefone,
                        Integer celular,
                        Integer watsapp,
                        Long formacaoId,
                        Date dataNascimento,
                        Sexo sexo,
                        String estadoCivil,
                        String nomeMae,
                        String nomePai,
                        Long lotacaoId,
                        Nivel nivel,
                        CargoClasse classe,
                        Integer padrao) {
}
