package br.com.vermser.pessoaapi.security;

import br.com.vermser.pessoaapi.entity.UsuarioEntity;
import br.com.vermser.pessoaapi.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;




@Service
@RequiredArgsConstructor
public class TokenService {

    @Autowired
    private UsuarioService usuarioService;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;
    public String getToken(UsuarioEntity usuarioEntity) {

        Date now = new Date();
        Date exp = new Date(now.getTime() + Long.parseLong(expiration));

        String token = Jwts.builder()
                .setIssuer("pessoa-api")
                .claim(Claims.ID, usuarioEntity.getIdUsuario())
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        return TokenAuthenticationFilter.BEARER + token;
    }

//    public String getToken (String login, String password){
//        Optional<UsuarioEntity> optionalUsuario = usuarioService.findyByLoginAndPassord(login,password);
//        if(optionalUsuario.isPresent()){
//            String token = getToken(optionalUsuario.get());
//            return token;
//        }
//        throw new PessoaNaoCadastradaException("Usuario ou senha invalidos");
//    }

    public UsernamePasswordAuthenticationToken isValid(String token) {
        if (token == null) {
            return null;
        }

        Claims payload = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        Integer idUsuario = payload.get(Claims.ID, Integer.class);

        if (idUsuario != null) {
            return new UsernamePasswordAuthenticationToken(idUsuario, null, Collections.emptyList());
        }

        return null;
    }
}
