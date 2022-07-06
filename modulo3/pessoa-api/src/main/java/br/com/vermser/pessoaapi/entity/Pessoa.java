package br.com.vermser.pessoaapi.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Pessoa {
    private Integer idPessoa;
    private LocalDate dataNascimento;
    private String cpf;
    private String nome;

    public Pessoa(Integer idPessoa, String nome, LocalDate dataNascimento, String cpf) {
        this.idPessoa = idPessoa;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Pessoa(Integer idPessoa){
        this.idPessoa = idPessoa;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pessoa " +
                ", nome='" + nome + '\''+
                "idPessoa=" + idPessoa +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return idPessoa.equals(pessoa.idPessoa) && Objects.equals(dataNascimento, pessoa.dataNascimento) && Objects.equals(cpf, pessoa.cpf) && Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, dataNascimento, cpf, nome);
    }
}
