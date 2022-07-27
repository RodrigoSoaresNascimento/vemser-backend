package br.com.vermser.pessoaapi.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PessoaCompletoDTO extends PessoaCreateDTO {

    private Integer idPessoa;

    private List<EnderecoDTO> enderecosDTO;

    private List<ContatoDTO> contatosDTO;

    private PetDTO petDTO;
}
