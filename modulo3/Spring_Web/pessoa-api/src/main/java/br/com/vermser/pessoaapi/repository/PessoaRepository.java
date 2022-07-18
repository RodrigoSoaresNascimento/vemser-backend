package br.com.vermser.pessoaapi.repository;

import br.com.vermser.pessoaapi.entity.Pessoa;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class PessoaRepository {
    private static List<Pessoa> listaPessoas = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();

    public PessoaRepository() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //18/10/2020
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "Maicon Gerardi", LocalDate.parse("10/10/1990", formatter), "12345678910", "rodrigo.soares@dbccompany.com.br"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "Charles Pereira", LocalDate.parse("08/05/1985", formatter), "12345678911","rodrigo.soares@dbccompany.com.br"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "Marina Oliveira", LocalDate.parse("30/03/1970", formatter), "12345678912","rodrigo.soares@dbccompany.com.br"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "Rafael Lazzari", LocalDate.parse("01/07/1990", formatter), "12345678916","rodrigo.soares@dbccompany.com.br"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "Ana", LocalDate.parse("01/07/1990", formatter), "12345678917","rodrigo.soares@dbccompany.com.br"));
    }

    public List<Pessoa> list() {
        return listaPessoas;
    }

    public Pessoa create (Pessoa pessoa){
        pessoa.setIdPessoa(COUNTER.incrementAndGet());
        listaPessoas.add(pessoa);
        return pessoa;
    }

}
