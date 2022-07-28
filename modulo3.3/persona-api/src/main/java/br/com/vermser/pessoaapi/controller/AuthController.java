package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.dto.LoginDTO;
import br.com.vermser.pessoaapi.dto.UsuarioCreateDTO;
import br.com.vermser.pessoaapi.dto.UsuarioDTO;
import br.com.vermser.pessoaapi.entity.UsuarioEntity;
import br.com.vermser.pessoaapi.security.TokenService;
import br.com.vermser.pessoaapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO loginDTO) {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getLogin(),
                        loginDTO.getSenha()
                );

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        Object usuarioLogado = authentication.getPrincipal();

        UsuarioEntity usuarioEntity = (UsuarioEntity) usuarioLogado;

        return tokenService.getToken(usuarioEntity);
    }

    @PostMapping("/create")
    public UsuarioDTO create (@RequestBody @Valid UsuarioCreateDTO usuarioCreateDTO){
        return service.create(usuarioCreateDTO);
    }
}
