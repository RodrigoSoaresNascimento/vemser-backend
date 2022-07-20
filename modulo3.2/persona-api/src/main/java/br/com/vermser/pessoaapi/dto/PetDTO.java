package br.com.vermser.pessoaapi.dto;

import br.com.vermser.pessoaapi.entity.PessoaEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {

    private Integer idPet;


    private Integer idPessoa;

    @NotBlank(message = "Name is mandatory")
    @NotNull
    private String nome;


    private Integer tipo;

    private PessoaDTO pessoa;

}
