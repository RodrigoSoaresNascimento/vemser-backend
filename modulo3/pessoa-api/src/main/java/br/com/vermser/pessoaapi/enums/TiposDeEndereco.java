package br.com.vermser.pessoaapi.enums;

public enum TiposDeEndereco {

    RESIDENCIAL(1),
    COMERCIAL(2);

    Integer tipoDeEndereco;

    TiposDeEndereco(Integer tipoDeEndereco) {
        this.tipoDeEndereco = tipoDeEndereco;
    }

    public Integer getTipoDeEndereco() {
        return tipoDeEndereco;
    }
}
