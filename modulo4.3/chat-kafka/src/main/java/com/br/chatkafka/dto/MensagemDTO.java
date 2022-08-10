package com.br.chatkafka.dto;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensagemDTO {
    @Schema(hidden = true)
    private String usuario;
    private String mensagem;
    @Schema(hidden = true)
    private LocalDateTime dataCriacao;

}
