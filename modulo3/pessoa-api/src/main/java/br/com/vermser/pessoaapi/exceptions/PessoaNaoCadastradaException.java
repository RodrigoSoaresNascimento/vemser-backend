package br.com.vermser.pessoaapi.exceptions;

public class PessoaNaoCadastradaException extends Exception{

    public PessoaNaoCadastradaException(String mensagem){
        super(mensagem);
    }
}
