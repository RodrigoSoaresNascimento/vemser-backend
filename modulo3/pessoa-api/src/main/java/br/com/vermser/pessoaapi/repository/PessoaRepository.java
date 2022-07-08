package br.com.vermser.pessoaapi.repository;

import br.com.vermser.pessoaapi.entity.Pessoa;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Repository
public class PessoaRepository {
    private static List<Pessoa> listaPessoas = new ArrayList<>();

    public PessoaRepository() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //18/10/2020
        listaPessoas.add(new Pessoa(1, "Maicon Gerardi", LocalDate.parse("10/10/1990", formatter), "12345678910"));
        listaPessoas.add(new Pessoa(2, "Charles Pereira", LocalDate.parse("08/05/1985", formatter), "12345678911"));
        listaPessoas.add(new Pessoa(3, "Marina Oliveira", LocalDate.parse("30/03/1970", formatter), "12345678912"));
        listaPessoas.add(new Pessoa(4, "Rafael Lazzari", LocalDate.parse("01/07/1990", formatter), "12345678916"));
        listaPessoas.add(new Pessoa(5, "Ana", LocalDate.parse("01/07/1990", formatter), "12345678917"));
    }

    public List<Pessoa> list() {
        return listaPessoas;
    }

}
