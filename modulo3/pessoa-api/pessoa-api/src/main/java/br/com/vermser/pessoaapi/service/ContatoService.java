package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.entity.Contato;
import br.com.vermser.pessoaapi.repository.ContatoRepository;


import java.util.List;

public class ContatoService {

    private ContatoRepository contatoRepository;

    public ContatoService (){
        contatoRepository = new ContatoRepository();
    }

    public Contato create (Contato contato){
        return contatoRepository.create(contato);

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
