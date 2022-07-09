package br.com.vermser.pessoaapi.exceptions;

public class PessoaNaoCadastradaException extends RuntimeException{

    public PessoaNaoCadastradaException(String mensagem){
        super(mensagem);
    }
}
