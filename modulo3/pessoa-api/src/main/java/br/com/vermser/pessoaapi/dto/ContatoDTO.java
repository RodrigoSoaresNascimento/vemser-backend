package br.com.vermser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContatoDTO extends ContatoCreateDTO {

    @Schema(description = "identificação unica de contato")
    private Integer idContato;
}
