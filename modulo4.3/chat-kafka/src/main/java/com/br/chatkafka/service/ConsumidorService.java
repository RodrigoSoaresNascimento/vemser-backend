package com.br.chatkafka.service;

import com.br.chatkafka.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumidorService {

    private final ObjectMapper objectMapper;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "${kafka.client-id}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "chatGeral")
    public void consumirGeral(@Payload String mensagem,
                              @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                              @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mensagemDTO.getDataCriacao().format(formatter))
                .append(" ")
                .append("[")
                .append(mensagemDTO.getUsuario())
                .append("]:")
                .append(mensagemDTO.getMensagem());
        log.info("####{consume} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, stringBuilder);
    }

    @KafkaListener(
            topics = "${kafka.topic.rodrigo}", // meu-primeiro-topico
            groupId = "${kafka.client-id}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "rodrigo")
    public void consumirPrivado(@Payload String mensagem,
                                @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mensagemDTO.getDataCriacao().format(formatter))
                .append(" ")
                .append("[")
                .append(mensagemDTO.getUsuario())
                .append("]")
                .append("(privada):")
                .append(mensagemDTO.getMensagem());
        log.info("####{consume} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, stringBuilder);
    }

}
