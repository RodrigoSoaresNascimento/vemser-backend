package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.entity.Pessoa;
import br.com.vermser.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

//    public PessoaService (){
//        //pessoaRepository = new PessoaRepository();
//    }
    public static AtomicInteger COUNTER = new AtomicInteger();

    public Pessoa create (Pessoa pessoa){

            pessoa.setIdPessoa(COUNTER.incrementAndGet());
            pessoaRepository.list().add(pessoa);
            return pessoa;
    }

    public List<Pessoa> list (){
        return pessoaRepository.list();
    }

    public Pessoa update (Integer id
    , Pessoa pessoaAtualizar) throws Exception {

        Pessoa pessoaRecuperada = findByid(id);
        pessoaRecuperada.setIdPessoa(COUNTER.incrementAndGet());
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaRecuperada;
    }

    public void delete (Integer id) throws Exception {
        Pessoa pessoaRecuperada = findByid(id);
        pessoaRepository.list().remove(pessoaRecuperada);

    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public boolean findById (Integer idPessoa){
        return pessoaRepository.list().stream()
                .anyMatch(pessoa -> pessoa.getIdPessoa().equals(idPessoa));
    }

    public Pessoa findByid (Integer id) throws Exception {
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não econtrada"));
        return pessoaRecuperada;
    }

}
