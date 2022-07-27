package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.dto.LoginDTO;
import br.com.vermser.pessoaapi.entity.UsuarioEntity;
import br.com.vermser.pessoaapi.exceptions.PessoaNaoCadastradaException;
import br.com.vermser.pessoaapi.security.TokenService;
import br.com.vermser.pessoaapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO loginDTO) {
        Optional<UsuarioEntity> usuario = service.findyByLoginAndPassord(loginDTO.getLogin(), loginDTO.getSenha());
        if(usuario.isPresent()){
            String token = tokenService.getToken(usuario.get());
            return token;
        }
        throw new PessoaNaoCadastradaException("Usuario ou senha invalidos");

    }
}
