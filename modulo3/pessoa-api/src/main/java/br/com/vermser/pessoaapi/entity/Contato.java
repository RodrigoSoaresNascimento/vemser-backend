package br.com.vermser.pessoaapi.entity;

import br.com.vermser.pessoaapi.enums.TiposDeEndereco;

import java.time.LocalDate;

public class Contato {


    private Integer idContato;
    private String numero;
    private String descricao;
    private String tipoEndereco;

    private Integer idPessoa;

    public Contato(Integer idPessoa, Integer idContato, String numero, String descricao, String tipoEndereco) {
       this.idPessoa = idPessoa;
        this.idContato = idContato;
        this.numero = numero;
        this.descricao = descricao;
        this.tipoEndereco = tipoEndereco;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "idPessoa=" + idContato +
                "idContato=" + idContato +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                ", tipoEndereco=" + TiposDeEndereco.valueOf(tipoEndereco) +
                '}';
    }
}
