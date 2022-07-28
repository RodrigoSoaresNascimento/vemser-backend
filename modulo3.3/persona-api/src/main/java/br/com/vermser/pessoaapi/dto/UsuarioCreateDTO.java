package br.com.vermser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioCreateDTO {

    @Schema(example = "chico")
    @NotBlank
    private String login;

    @Schema(example = "Drag@n1")
    @NotBlank
    private String senha;

}
