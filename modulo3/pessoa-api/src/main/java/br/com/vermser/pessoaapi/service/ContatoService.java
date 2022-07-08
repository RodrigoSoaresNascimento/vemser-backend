package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.entity.Contato;
import br.com.vermser.pessoaapi.exceptions.PessoaNaoCadastradaException;
import br.com.vermser.pessoaapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

import static br.com.vermser.pessoaapi.service.PessoaService.COUNTER;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaService pessoaService;

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
        Contato contatoRecuperado = findByid(id);
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        contatoRecuperado.setTipoEndereco(contatoAtualizar.getTipoEndereco());
        return contatoRecuperado;
    }

    public void delete (Integer id) throws Exception {
        Contato contatoRecuperado = findByid(id);
        contatoRepository.list().remove(contatoRecuperado);
    }

    public  List<Contato> listById (Integer id){
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public Contato findByid(Integer id) throws Exception {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrada"));
        return contatoRecuperado;
    }

}
