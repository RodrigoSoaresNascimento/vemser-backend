package br.com.vermser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Pessoa {

    private Integer idPessoa;

    private LocalDate dataNascimento;
    private String cpf;
    private String nome;

    private String email;

    public Pessoa(Integer idPessoa, String nome, LocalDate dataNascimento, String cpf, String email) {
        this.idPessoa = idPessoa;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa " +
                ", nome='" + nome + '\''+
                "idPessoa=" + idPessoa +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'';

    }

}
