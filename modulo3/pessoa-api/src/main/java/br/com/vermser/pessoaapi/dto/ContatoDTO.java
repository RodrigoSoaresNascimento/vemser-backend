package br.com.vermser.pessoaapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContatoDTO extends ContatoCreateDTO {

    private Integer idContato;
    private Integer idPessoa;
}
