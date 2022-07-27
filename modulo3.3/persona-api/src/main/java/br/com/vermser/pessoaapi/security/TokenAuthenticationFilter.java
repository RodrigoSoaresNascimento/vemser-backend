package br.com.vermser.pessoaapi.security;

import br.com.vermser.pessoaapi.entity.UsuarioEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;


public class TokenAuthenticationFilter  extends OncePerRequestFilter {


    private final TokenService tokenService;

    public TokenAuthenticationFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    private static final  String BEARER = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = getTokenFromHeader(request);
        Optional<UsuarioEntity> optional = tokenService.isValid(token);
        authenticate(optional);
        filterChain.doFilter(request, response);
    }

    public void authenticate(Optional<UsuarioEntity> optionalUsuarioEntity){
        if(optionalUsuarioEntity.isPresent()){
            UsuarioEntity usuario = optionalUsuarioEntity.get();
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(usuario.getLogin(), null, Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }else {
            SecurityContextHolder.getContext().setAuthentication(null);

        }
    }

    private String getTokenFromHeader (HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token == null){
            return null;
        }
        return token.replace(BEARER, "");
    }
}
