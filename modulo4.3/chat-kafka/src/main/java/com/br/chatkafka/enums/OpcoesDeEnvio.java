package com.br.chatkafka.enums;

import java.util.Arrays;

public enum OpcoesDeEnvio {

    GERAL("chat-geral"),
    BRUNO("chat-bruno"),
    CASTRO("chat-castro"),
    CESAR("chat-cesar"),
    DAYVIDSON("chat-dayvidson"),
    GABRIEL("chat-gabriel"),
    JEAN("chat-jean"),
    MACHADO("chat-machado"),
    PAULO("chat-paulo"),
    RAFAEL("chat-rafael"),
    RODRIGO("chat-rodrigo"),
    WILLIAN("chat-willian");



    private String chat;

    OpcoesDeEnvio(String chat){
        this.chat = chat;
    }

    public String getChat(){return chat;}

    public static OpcoesDeEnvio ofTipo(String chat){
        return Arrays.stream(OpcoesDeEnvio.values())
                .filter(tp -> tp.getChat().equals(chat))
                .findFirst()
                .get();
    }
}
