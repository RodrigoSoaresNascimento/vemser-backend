package br.com.vermser.pessoaapi.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContatoCreateDTO {

    @NotBlank(message = "Numero is mandatory")
    @NotNull
    @Size(min = 13, max = 13)
    private String numero;

    @NotNull
    private String descricao;
    @NotNull
    private String tipoEndereco;
}
