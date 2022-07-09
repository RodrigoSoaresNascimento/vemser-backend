package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vermser.pessoaapi.dto.PessoaDTO;
import br.com.vermser.pessoaapi.entity.Pessoa;
import br.com.vermser.pessoaapi.exceptions.PessoaNaoCadastradaException;
import br.com.vermser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

//    public PessoaService (){
//        //pessoaRepository = new PessoaRepository();
//    }

    public PessoaDTO create (PessoaCreateDTO pessoa) {

        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        pessoaEntity = pessoaRepository.create(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        log.info("Pessoa criada");
        return pessoaDTO;
    }

    public List<PessoaDTO> list (){
        return pessoaRepository.list()
                .stream()
                .map(p -> objectMapper.convertValue(p,PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update (Integer id
    , PessoaCreateDTO pessoaAtualizar) throws Exception {

        Pessoa pessoaRecuperada = findById(id);
        pessoaRecuperada.setIdPessoa(id);
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        log.info("Pessoa atualizada");
        return objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);
    }

    public void delete (Integer id) throws Exception {
        Pessoa pessoaRecuperada = findById(id);
        log.info("Pessoa removida!");
        pessoaRepository.list().remove(pessoaRecuperada);

    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.list().stream()
                .map(p -> objectMapper.convertValue(p, PessoaDTO.class))
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public Pessoa findById (Integer id) throws PessoaNaoCadastradaException {
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new PessoaNaoCadastradaException("Pessoa não econtrada"));
        return pessoaRecuperada;
    }

}
