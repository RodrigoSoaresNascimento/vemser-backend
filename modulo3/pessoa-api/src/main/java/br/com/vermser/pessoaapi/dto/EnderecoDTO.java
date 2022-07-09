package br.com.vermser.pessoaapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EnderecoDTO extends EnderecoCreateDTO{

    private Integer idPessoa;
    private Integer idEndereco;

}
