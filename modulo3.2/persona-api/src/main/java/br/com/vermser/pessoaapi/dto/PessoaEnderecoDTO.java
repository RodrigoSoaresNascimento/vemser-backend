package br.com.vermser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaEnderecoDTO extends PessoaCreateDTO{

    @Schema(description = "lista de endereços da pessoa")
    private List<EnderecoDTO> enderecosDTO;
}
