package br.com.vermser.pessoaapi.dto;

import br.com.vermser.pessoaapi.enums.Sexo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DadosPessoaisDTO {

    private String cnh;
    private String cpf;
    private String nome;
    private String nomeMae;
    private String nomePai;
    private String rg;
    private Sexo sexo;
    private String tituloEleitor;
}
