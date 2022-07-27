package br.com.vermser.pessoaapi.enums;

import java.util.Arrays;

public enum TipoDePet {

    CACHORRO(1),
    GATO(2),
    QUAXINIM(3);

    private Integer tipoPet;

    TipoDePet(Integer tipoPet) {
        this.tipoPet = tipoPet;
    }

    public static TipoDePet ofTipo (Integer tipoDePet) {
        return Arrays.stream(TipoDePet.values())
                .filter(tp -> tp.getTipoDePet().equals(tipoDePet))
                .findFirst()
                .get();
    }

    public Integer getTipoDePet() {
        return tipoPet;
    }
}
