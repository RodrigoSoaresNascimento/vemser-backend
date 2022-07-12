package br.com.vermser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContatoCreateDTO {

    @Schema(description = "numero de celular/telefone")
    @NotBlank(message = "Numero is mandatory")
    @NotNull
    @Size(min = 13, max = 13)
    private String numero;

    @NotNull
    private String descricao;
    @Schema(description = "tipo de endereço = RESIDENCIAL/COMERCIAL")
    @NotNull
    private String tipoEndereco;

    private Integer idPessoa;
}
