package br.com.meusindicato.sindicato.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Formacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "formacaoId")
    private Long formacaoId;

    private String nomeFormacao;

    @Column(name = "formacaoCodigo",unique = true)
    private Integer codigoFormacao;

    @OneToMany(mappedBy = "formacao",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Pessoa> formacaoPessoas;

    public Formacao(){}

    public Formacao(Integer codigoFormacao,String nomeFormacao) {
        this.nomeFormacao = nomeFormacao;
        this.codigoFormacao = codigoFormacao;
    }

    @Override
    public String toString() {
        return "Formacao{" +
                "formacaoId=" + formacaoId +
                ", nomeFormacao='" + nomeFormacao + '\'' +
                ", codigoFormacao=" + codigoFormacao +
                ", formacaoPessoas=" + formacaoPessoas +
                '}';
    }
}
