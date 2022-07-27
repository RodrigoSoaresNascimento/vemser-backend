package br.com.vermser.pessoaapi.dto;

import br.com.vermser.pessoaapi.entity.PessoaEntity;
import br.com.vermser.pessoaapi.enums.TipoDePet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {

    @Schema(description = "identificador unico do pet")
    private Integer idPet;

    @Schema(description = "identificador unico da pessoa")
    private Integer idPessoa;

    @NotBlank(message = "Name is mandatory")
    @NotNull
    private String nome;

    @Schema(description = "tipo de animal da pessoa")
    private TipoDePet tipo;

}
