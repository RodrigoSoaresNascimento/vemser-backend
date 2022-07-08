package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.entity.Contato;
import br.com.vermser.pessoaapi.exceptions.PessoaNaoCadastradaException;
import br.com.vermser.pessoaapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaService pessoaService;

    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoService (){
        //contatoRepository = new ContatoRepository();
        //pessoaRepository = new PessoaRepository();
    }

    public Contato create (Contato contato, Integer idPessoa) throws PessoaNaoCadastradaException {

        boolean pessoaCadastrada = pessoaService.findById(idPessoa);

        if(pessoaCadastrada){
            contato.setIdPessoa(idPessoa);
            contato.setIdContato(COUNTER.incrementAndGet());
            contatoRepository.list().add(contato);
            return contato;
        }else{
            throw new PessoaNaoCadastradaException("Não existe pessoa cadastrada com esse id");
        }

    }

    public List<Contato> list (){
        return contatoRepository.list();
    }

    public Contato update (Integer id
            , Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperado = contatoRepository.findByid(id);
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        contatoRecuperado.setTipoEndereco(contatoAtualizar.getTipoEndereco());
        return contatoRecuperado;
    }

    public void delete (Integer id) throws Exception {
        Contato contatoRecuperado = contatoRepository.findByid(id);
        contatoRepository.list().remove(contatoRecuperado);
    }

    public  List<Contato> listById (Integer id){
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

}
