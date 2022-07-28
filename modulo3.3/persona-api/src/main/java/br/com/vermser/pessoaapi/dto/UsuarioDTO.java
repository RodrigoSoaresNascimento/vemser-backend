package br.com.vermser.pessoaapi.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioDTO extends UsuarioCreateDTO {

    private Integer idUsuario;
}
