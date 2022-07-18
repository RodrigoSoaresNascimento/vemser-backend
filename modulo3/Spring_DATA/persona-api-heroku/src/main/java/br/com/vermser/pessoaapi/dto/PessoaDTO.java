package br.com.vermser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PessoaDTO  extends PessoaCreateDTO{

    @Schema(description = "identificação unica de pessoa")
    private Integer idPessoa;

}
