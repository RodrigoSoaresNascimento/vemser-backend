package br.com.vermser.pessoaapi.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaCompostaDTO {

    //private Integer id;
    private String nome;
    private String email;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private String petNome;

}
