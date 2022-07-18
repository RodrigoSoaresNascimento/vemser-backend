package br.com.vermser.pessoaapi.repository;

import br.com.vermser.pessoaapi.entity.Contato;
import br.com.vermser.pessoaapi.enums.TiposDeEndereco;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;



@Repository
public class ContatoRepository {

    private static List<Contato> listaContatos = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {

            listaContatos.add(new Contato(1, COUNTER.incrementAndGet(), "(64) 2944-9589","trabalho", TiposDeEndereco.COMERCIAL.name()));
            listaContatos.add(new Contato(2, COUNTER.incrementAndGet(), "(37) 3725-3777", "casa",TiposDeEndereco.RESIDENCIAL.name()));
            listaContatos.add(new Contato(3, COUNTER.incrementAndGet(), "(61) 2664-6246", "whatsapp",TiposDeEndereco.RESIDENCIAL.name()));
            listaContatos.add(new Contato(4 , COUNTER.incrementAndGet(),"(69) 3979-1165", "whatsapp",TiposDeEndereco.COMERCIAL.name()));
            listaContatos.add(new Contato(5, COUNTER.incrementAndGet(),"(68) 2657-4187", "trabalho",TiposDeEndereco.RESIDENCIAL.name()));

    }

    public List<Contato> list() {
        return listaContatos;
    }

    public Contato create (Contato contato){
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return  contato;
    }

}
