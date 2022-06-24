package models;

import java.util.ArrayList;

public class Cliente {

    private String nome;
    private String cpf;
    private ArrayList <Contato> contatos = new ArrayList<>();
    private ArrayList <Endereco> enderecos = new ArrayList<>();

    public Cliente(String nome, String cpf, ArrayList<Contato> contatos, ArrayList<Endereco> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public void imprimirContatos() {

        for(Contato contato : this.contatos){
            if(contato != null){
                System.out.println(contato);
            }
        }
    }

    public void imprimirEnderecos() {

        for(Endereco endereco : this.enderecos){

            if(endereco != null){
                System.out.println(endereco);
            }
        }
    }

    public void imprimirCliente() {

        System.out.printf("O cliente é : %s\ne seu cpf é de : %s\n",getNome(),getCpf());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
