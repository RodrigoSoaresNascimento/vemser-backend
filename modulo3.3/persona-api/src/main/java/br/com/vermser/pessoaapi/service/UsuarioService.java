package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.entity.UsuarioEntity;
import br.com.vermser.pessoaapi.exceptions.PessoaNaoCadastradaException;
import br.com.vermser.pessoaapi.repository.Usuariorepository;
import br.com.vermser.pessoaapi.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private Usuariorepository usuariorepository;

    public Optional<UsuarioEntity> findyByLoginAndPassord (String login, String password){
        return usuariorepository.findByLoginAndSenha(login,password);
    }

    // FIXME construir métodoss necessários para o usuário
}
