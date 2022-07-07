package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.entity.Pessoa;
import br.com.vermser.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

//    public PessoaService (){
//        //pessoaRepository = new PessoaRepository();
//    }

    public Pessoa create (Pessoa pessoa){

        boolean pesssoaSemNome = StringUtils.isBlank(pessoa.getNome());
        boolean pessoaSemData = ObjectUtils.isEmpty(pessoa.getDataNascimento());
        boolean cpfValido = pessoa.getCpf().length() == 11;

        if(!pesssoaSemNome && !pessoaSemData && !ObjectUtils.isEmpty(pessoa) && cpfValido){
            return pessoaRepository.create(pessoa);
        }

        return pessoa;
    }

    public List<Pessoa> list (){
        return pessoaRepository.list();
    }

    public Pessoa update (Integer id
    , Pessoa pessoa) throws Exception {
       return pessoaRepository.update(id, pessoa);
    }

    public void delete (Integer id) throws Exception {
        pessoaRepository.delete(id);
    }

    public  List<Pessoa> listByName (String nome){
        return pessoaRepository.listByName(nome);
    }



}
