package br.com.vermser.pessoaapi.enums;

import java.util.Arrays;

public enum TiposDeEndereco {

    RESIDENCIAL(1),
    COMERCIAL(2);

    private Integer tipoEndereco;

    TiposDeEndereco(Integer tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public static TiposDeEndereco ofTipo (Integer tipoDeEndereco) {
        return Arrays.stream(TiposDeEndereco.values())
                .filter(tp -> tp.getTipoDeEndereco().equals(tipoDeEndereco))
                .findFirst()
                .get();
    }

    public Integer getTipoDeEndereco() {
        return tipoEndereco;
    }
}
