package br.com.vermser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {


    @Past
    @NotNull
    private LocalDate dataNascimento;
    @Schema(description = "cpf da pessoa")
    @NotBlank(message = "Cpf is mandatory")
    @NotNull
    @Size(min = 11, max = 11)
    private String cpf;
    @Schema(description = "Nome da Pessoa")
    @NotBlank(message = "Name is mandatory")
    @NotNull
    private String nome;

    //@Email
    @Schema(description = "email da pessoa")
    @NotBlank(message = "Não pode ser vazio")
    private String email;

}
