package br.com.vermser.pessoaapi.repository;

import br.com.vermser.pessoaapi.entity.Endereco;
import br.com.vermser.pessoaapi.enums.TiposDeEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {

    private static List<Endereco> listaEnderecos = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository (){

        listaEnderecos.add(new Endereco(1, COUNTER.incrementAndGet(),TiposDeEndereco.COMERCIAL, "Rua", 46, "Centro", "13076-413","Campinas", "SP", "Brasil"));
        listaEnderecos.add(new Endereco(2,COUNTER.incrementAndGet() ,TiposDeEndereco.COMERCIAL, "Rua Santo Anibale Maria Di Francia", 586, "Bairro", "37900-038","Passos", "MG", "Brasil"));
        listaEnderecos.add(new Endereco(3,COUNTER.incrementAndGet() ,TiposDeEndereco.RESIDENCIAL, "Praça Adolfo João Hilário da Veiga", 367, "Cidade Industrial", "81280-345","Curitiba", "PR", "Brasil"));
        listaEnderecos.add(new Endereco(4,COUNTER.incrementAndGet() ,TiposDeEndereco.COMERCIAL, "Rua Cento e Cinquenta e Sete", 760, "Morada do Sol II (Itambi)", "24865-380","Itaboraí", "RJ", "Brasil"));
        listaEnderecos.add(new Endereco(5,COUNTER.incrementAndGet() ,TiposDeEndereco.RESIDENCIAL, "Conjunto Tabuleta", 905, "Tabuleta", "64019-640","Teresina", "PI", "Brasil"));

    }

    public List<Endereco> list () {
        return listaEnderecos;
    }

}
