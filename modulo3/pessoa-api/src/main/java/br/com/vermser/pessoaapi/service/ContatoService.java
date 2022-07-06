package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.entity.Contato;
import br.com.vermser.pessoaapi.exceptions.PessoaNaoCadastradaException;
import br.com.vermser.pessoaapi.repository.ContatoRepository;
import br.com.vermser.pessoaapi.repository.PessoaRepository;


import java.util.List;

public class ContatoService {

    private ContatoRepository contatoRepository;

    private PessoaRepository pessoaRepository;

    public ContatoService (){
        contatoRepository = new ContatoRepository();
        pessoaRepository = new PessoaRepository();
    }

    public Contato create (Contato contato, Integer idPessoa) throws PessoaNaoCadastradaException {
        boolean pessoaCadastrada = pessoaRepository.list().stream()
                .anyMatch(contato1 -> contato1.getIdPessoa().equals(idPessoa));

        if(pessoaCadastrada){
            contato.setIdPessoa(idPessoa);
            return contatoRepository.create(contato);
        }else{
            throw new PessoaNaoCadastradaException("Não existe pessoa cadastrada com esse id");
        }

    }

    public List<Contato> list (){
        return contatoRepository.list();
    }

    public Contato update (Integer id
            , Contato contato) throws Exception {
        return contatoRepository.update(id, contato);
    }

    public void delete (Integer id) throws Exception {
        contatoRepository.delete(id);
    }

    public  List<Contato> listById (Integer id){
        return contatoRepository.listById(id);
    }

}
