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
    @Past
    @NotNull
    private LocalDate dataNascimento;
    @NotBlank(message = "Cpf is mandatory")
    @NotNull
    @Size(min = 11, max = 11)
    private String cpf;
    @NotBlank(message = "Name is mandatory")
    @NotNull
    private String nome;

    @NotBlank
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
