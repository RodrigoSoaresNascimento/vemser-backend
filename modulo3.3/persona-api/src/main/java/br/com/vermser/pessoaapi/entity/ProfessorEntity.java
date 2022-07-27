package br.com.vermser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="PROFESSOR")
public class ProfessorEntity {

    @EmbeddedId
    ProfessorPk professorPk;

    @Column(name = "nome")
    private String nome;
    @Column(name = "salario")
    private Double salario;

}
