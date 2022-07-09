package br.com.vermser.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {

    @Past
    @NotNull
    private LocalDate dataNascimento;
    @NotBlank(message = "Cpf is mandatory")
    @NotNull
    @Size(min = 11, max = 11)
    private String cpf;
    @NotBlank(message = "Name is mandatory")
    @NotNull
    private String nome;

}
