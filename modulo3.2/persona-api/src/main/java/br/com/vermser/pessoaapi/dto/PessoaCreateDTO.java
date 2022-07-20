package br.com.vermser.pessoaapi.dto;

import br.com.vermser.pessoaapi.entity.EnderecoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaCreateDTO {

    @Schema(description = "data de nascimento da pessoa")
    @Past
    @NotNull
    private LocalDate dataNascimento;

    @Schema(description = "cpf da pessoa")
    @NotBlank(message = "Cpf is mandatory")
    @NotNull
    @Size(min = 11, max = 11)
    private String cpf;

    @Schema(description = "Nome da PessoaEntity")
    @NotBlank(message = "Name is mandatory")
    @NotNull
    private String nome;

    //@Email
    @Schema(description = "email da pessoa")
    @NotBlank(message = "Não pode ser vazio")
    private String email;
    @Schema(description = "lista de contatos da pessoa")
    private Set<EnderecoEntity> enderecos;

}
