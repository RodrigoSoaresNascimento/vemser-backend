package br.com.vermser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EnderecoDTO extends EnderecoCreateDTO{

    @Schema(description = "identificação unica de endereço de uma pessoa")
    private Integer idEndereco;

}
