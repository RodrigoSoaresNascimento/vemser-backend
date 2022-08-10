package com.br.chatkafka.controller;

import com.br.chatkafka.enums.OpcoesDeEnvio;
import com.br.chatkafka.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/enviar-string")
    public void enviarMensagemParaOTopico(String mensagem){
        produtorService.enviarMensagemString(mensagem);
    }

    @PostMapping("/enviar-mensagem")
    public void enviarMensagemParaOTopico(@RequestParam List<OpcoesDeEnvio> opcoesDeEnvioList , @RequestBody String mensagem) throws JsonProcessingException {
        produtorService.enviarMensage(mensagem,opcoesDeEnvioList);
    }

}

