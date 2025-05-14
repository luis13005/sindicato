package br.com.meusindicato.sindicato.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
public class Pessoa {

    @Id
    @Column(name = "pessoaId")
    private Long pessoaId;

    @Column(name = "nomeCompleto")
    private String nomeCompleto;

    @OneToMany(mappedBy = "pessoa")
    private List<Sindicalista> sindicalistaList;

    @Column(unique = true)
    private Integer rg;

    @Column(name = "orgaoExpedidor")
    private String orgaoExpedidor;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataEmissaoRg;

    private Integer cep;

    private String endereco;

    private String bairro;

    @ManyToOne
    @JoinColumn(name = "cidadeAtualId")
    private Cidade cidadeAtual;

    @ManyToOne
    @JoinColumn(name = "cidadeNaturalId")
    private Cidade cidadeNatural;

    private String email;

    private Integer telefone;

    private Integer celular;

    private Integer watsapp;

    @ManyToOne
    @JoinColumn(name = "formacaoId")
    private Formacao formacao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    private Sexo sexo;

    private EstadoCivil estadoCivil;

    private String nomeMae;

    private String nomePai;

    private Nivel nivel;

    private CargoClasse classe;

    @Column(length = 3,nullable = true)
    private Integer padrao;

    @ManyToOne
    @JoinColumn(name = "cargoId")
    private Cargo cargo;

    @OneToMany(mappedBy = "pessoa")
    private List<Dependentes> dependentes;

    @ManyToOne
    @JoinColumn(name = "lotacaoId")
    private Lotacao lotacao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataSindicalizado;

    public Pessoa() {}

    public Pessoa(Long pessoaId, String nomeCompleto, List<Sindicalista> sindicalistaList, Integer rg, String orgaoExpedidor, Date dataEmissaoRg, Integer cep, String endereco, String bairro, Cidade cidadeAtual, Cidade cidadeNatural, String email, Integer telefone, Integer celular, Integer watsapp, Formacao formacao, Date dataNascimento, Sexo sexo, EstadoCivil estadoCivil, String nomeMae, String nomePai, Nivel nivel, CargoClasse classe, Integer padrao, Cargo cargo, List<Dependentes> dependentes, Lotacao lotacao, Date dataSindicalizado) {
        this.pessoaId = pessoaId;
        this.nomeCompleto = nomeCompleto;
        this.sindicalistaList = sindicalistaList;
        this.rg = rg;
        this.orgaoExpedidor = orgaoExpedidor;
        this.dataEmissaoRg = dataEmissaoRg;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidadeAtual = cidadeAtual;
        this.cidadeNatural = cidadeNatural;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.watsapp = watsapp;
        this.formacao = formacao;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.nivel = nivel;
        this.classe = classe;
        this.padrao = padrao;
        this.cargo = cargo;
        this.dependentes = dependentes;
        this.lotacao = lotacao;
        this.dataSindicalizado = dataSindicalizado;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public List<Sindicalista> getSindicalistaList() {
        return sindicalistaList;
    }

    public void setSindicalistaList(List<Sindicalista> sindicalistaList) {
        this.sindicalistaList = sindicalistaList;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }

    public Date getDataEmissaoRg() {
        return dataEmissaoRg;
    }

    public void setDataEmissaoRg(Date dataEmissaoRg) {
        this.dataEmissaoRg = dataEmissaoRg;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidadeAtual() {
        return cidadeAtual;
    }

    public void setCidadeAtual(Cidade cidadeAtual) {
        this.cidadeAtual = cidadeAtual;
    }

    public Cidade getCidadeNatural() {
        return cidadeNatural;
    }

    public void setCidadeNatural(Cidade cidadeNatural) {
        this.cidadeNatural = cidadeNatural;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public Integer getWatsapp() {
        return watsapp;
    }

    public void setWatsapp(Integer watsapp) {
        this.watsapp = watsapp;
    }

    public Formacao getFormacao() {
        return formacao;
    }

    public void setFormacao(Formacao formacao) {
        this.formacao = formacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Dependentes> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependentes> dependentes) {
        this.dependentes = dependentes;
    }

    public Lotacao getLotacao() {
        return lotacao;
    }

    public void setLotacao(Lotacao lotacao) {
        this.lotacao = lotacao;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public CargoClasse getClasse() {
        return classe;
    }

    public void setClasse(CargoClasse classe) {
        this.classe = classe;
    }

    public Integer getPadrao() {
        return padrao;
    }

    public void setPadrao(Integer padrao) {
        this.padrao = padrao;
    }

    public Date getDataSindicalizado() {
        return dataSindicalizado;
    }

    public void setDataSindicalizado(Date dataSindicalizado) {
        this.dataSindicalizado = dataSindicalizado;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "pessoaId=" + pessoaId +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", sindicalistaList=" + sindicalistaList +
                ", rg=" + rg +
                ", orgaoExpedidor='" + orgaoExpedidor + '\'' +
                ", dataEmissaoRg=" + dataEmissaoRg +
                ", cep=" + cep +
                ", endereco='" + endereco + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidadeAtual=" + cidadeAtual +
                ", cidadeNatural=" + cidadeNatural +
                ", email='" + email + '\'' +
                ", telefone=" + telefone +
                ", celular=" + celular +
                ", watsapp=" + watsapp +
                ", formacao=" + formacao +
                ", dataNascimento=" + dataNascimento +
                ", sexo=" + sexo +
                ", estadoCivil=" + estadoCivil +
                ", nomeMae='" + nomeMae + '\'' +
                ", nomePai='" + nomePai + '\'' +
                ", nivel=" + nivel +
                ", classe=" + classe +
                ", padrao=" + padrao +
                ", cargos=" + cargo +
                ", dependentes=" + dependentes +
                ", lotacao=" + lotacao +
                ", dataSindicalizado=" + dataSindicalizado +
                '}';
    }
}