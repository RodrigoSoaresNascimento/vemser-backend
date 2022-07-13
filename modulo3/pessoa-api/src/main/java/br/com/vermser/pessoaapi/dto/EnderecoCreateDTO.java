package br.com.vermser.pessoaapi.dto;

import br.com.vermser.pessoaapi.enums.TiposDeEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EnderecoCreateDTO {

    @Schema(description = "Tipo de enderenço = COMERCIAL/RESIDENCIAL")
    @NotNull
    private TiposDeEndereco tipo;

    @Schema(description = "identificação unica de pessoa")
    private Integer idPessoa;

    @Schema(description = "Tipo de localidade como, rua, bairro, avenida, etc")
    @NotNull
    @NotBlank(message = "Logradouro é obrigatório")
    @Size(max = 250)
    private String logradouro;


    @Schema(description = "numero da residencia")
    @NotNull
    @Min(1)
    private Integer numero;

    @Schema(description = "campo que permite mais informações sobre o endereço")
    private String complemento;

    @NotBlank(message = "Cep is mandatory")
    @NotNull
    @Size(min = 8, max = 8)
    private String cep;

    @Schema(description = "cidade de uma pessoa")
    @NotNull
    @NotBlank(message = "Cidade é obrigatório")
    @Size(max = 250)
    private String cidade;

    @Schema(description = "estado de uma pessoa")
    @NotBlank(message = "Estado é obrigatorio")
    private String estado;

    @Schema(description = "pais de uma pessoa")
    @NotBlank(message = "Pais é obrigatorio")
    private String pais;
}
