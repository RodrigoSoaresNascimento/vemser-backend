package br.com.vermser.pessoaapi.dto;

import br.com.vermser.pessoaapi.enums.TiposDeEndereco;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EnderecoCreateDTO {

    private TiposDeEndereco tipo;

    @NotNull
    @NotBlank(message = "Logradouro é obrigatório")
    @Size(max = 250)
    private String logradouro;

    @NotNull
    @Min(1)
    private Integer numero;
    private String complemento;

    @NotBlank(message = "Cep is mandatory")
    @NotNull
    @Size(min = 8, max = 8)
    private String cep;

    @NotNull
    @NotBlank(message = "Cidade é obrigatório")
    @Size(max = 250)
    private String cidade;

    @NotBlank(message = "Estado é obrigatorio")
    private String estado;

    @NotBlank(message = "Pais é obrigatorio")
    private String pais;
}
