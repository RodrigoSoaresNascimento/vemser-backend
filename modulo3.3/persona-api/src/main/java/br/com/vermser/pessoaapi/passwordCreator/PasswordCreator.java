package br.com.vermser.pessoaapi.passwordCreator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordCreator {
    public static void main(String[] args) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String senha = bCryptPasswordEncoder.encode("123");

        String minhaSenha = "$2a$10$OSdKzw0K0LaLPyj1EqOWte8U.cpTftzycrK5eQ/Wgu2GfB4wgpWu6";
        boolean matches = bCryptPasswordEncoder.matches("123",minhaSenha);
    }
}
