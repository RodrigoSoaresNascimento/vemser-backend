package br.com.vermser.pessoaapi.entity;

import br.com.vermser.pessoaapi.enums.TiposDeEndereco;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Endereco {
    private Integer idPessoa;
    private Integer idEndereco;

    @NotNull
    private TiposDeEndereco tipo;

    @NotNull
    @NotBlank(message = "Logradouro é obrigatório")
    @Size(max = 250)
    private String logradouro;

    @NotNull
    @Min(1)
    private Integer numero;
    private String complemento;

    @NotBlank(message = "Cep is mandatory")
    @NotNull
    @Size(min = 8, max = 8)
    private String cep;

    @NotNull
    @NotBlank(message = "Cidade é obrigatório")
    @Size(max = 250)
    private String cidade;

    @NotBlank(message = "Estado é obrigatorio")
    private String estado;

    @NotBlank(message = "Pais é obrigatorio")
    private String pais;

    public Endereco(Integer idPessoa, Integer idEndereco ,TiposDeEndereco tipo, String logradouro, Integer numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.idPessoa = idPessoa;
        this.idEndereco = idEndereco;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Endereco (){

    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public TiposDeEndereco getTipo() {
        return tipo;
    }

    public void setTipo(TiposDeEndereco tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Override
    public String toString() {
        return "Endereco " +
                "idPessoa = " + idPessoa +
                ", idEndereco = " + idEndereco +
                ", tipo = " + tipo +
                ", logradouro = '" + logradouro + '\'' +
                ", numero = " + numero +
                ", complemento = '" + complemento + '\'' +
                ", cep = '" + cep + '\'' +
                ", cidade = '" + cidade + '\'' +
                ", estado = '" + estado + '\'' +
                ", pais = '" + pais + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco)) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(idPessoa, endereco.idPessoa) && Objects.equals(idEndereco, endereco.idEndereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, idEndereco);
    }
}
