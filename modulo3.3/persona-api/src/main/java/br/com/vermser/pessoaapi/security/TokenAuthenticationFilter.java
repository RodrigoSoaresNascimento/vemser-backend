package br.com.vermser.pessoaapi.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TokenAuthenticationFilter  extends OncePerRequestFilter {


    private final TokenService tokenService;

    public TokenAuthenticationFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public static final String BEARER = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = getTokenFromHeader(request);

        SecurityContextHolder.getContext().setAuthentication(tokenService.isValid(token));

        filterChain.doFilter(request, response);
    }


    private String getTokenFromHeader (HttpServletRequest request){
        String token = request.getHeader("Authorization");

        if(token == null){
            return null;
        }

        return token.replace(BEARER, "");

    }
}
