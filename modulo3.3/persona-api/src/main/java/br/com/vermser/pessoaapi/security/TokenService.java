package br.com.vermser.pessoaapi.security;

import br.com.vermser.pessoaapi.entity.UsuarioEntity;
import br.com.vermser.pessoaapi.exceptions.PessoaNaoCadastradaException;
import br.com.vermser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {

    @Autowired
    private UsuarioService usuarioService;

    public String getToken(UsuarioEntity usuarioEntity) {
       String tokenTexto = usuarioEntity.getLogin() + ";" + usuarioEntity.getSenha();
       String token = Base64.getEncoder().encodeToString(tokenTexto.getBytes());
        return token;
    }

//    public String getToken (String login, String password){
//        Optional<UsuarioEntity> optionalUsuario = usuarioService.findyByLoginAndPassord(login,password);
//        if(optionalUsuario.isPresent()){
//            String token = getToken(optionalUsuario.get());
//            return token;
//        }
//        throw new PessoaNaoCadastradaException("Usuario ou senha invalidos");
//    }

    public Optional<UsuarioEntity> isValid(String token) {
        if(token == null){
            return Optional.empty();
        }
        byte[] decodeBytes = Base64.getUrlDecoder().decode(token);
        String decoded = new String(decodeBytes);
        String[] split = decoded.split(";");
        Optional<UsuarioEntity> optionalUsuario = usuarioService.findyByLoginAndPassord(split[0], split[1]);
        return optionalUsuario;
    }
}
