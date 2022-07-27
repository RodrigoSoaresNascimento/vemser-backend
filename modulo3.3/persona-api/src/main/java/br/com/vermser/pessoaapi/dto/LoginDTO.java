package br.com.vermser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginDTO {

    @Schema(example = "Beto")
    @NotNull
    private String login;

    @Schema(example = "Dr1g@n")
    @NotNull
    private String senha;

}
