package br.com.vermser.pessoaapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaCompostaDTO {

    private Integer idPessoa;
    private String nome;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private String nomePet;

}
