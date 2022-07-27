package br.com.vermser.pessoaapi.dto;

import br.com.vermser.pessoaapi.entity.ContatoEntity;
import br.com.vermser.pessoaapi.entity.EnderecoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PessoaDTO  extends PessoaCreateDTO{

    @Schema(description = "identificação unica de pessoa")
    private Integer idPessoa;

}
