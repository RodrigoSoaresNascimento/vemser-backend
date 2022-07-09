package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vermser.pessoaapi.dto.ContatoDTO;
import br.com.vermser.pessoaapi.entity.Contato;
import br.com.vermser.pessoaapi.entity.Pessoa;
import br.com.vermser.pessoaapi.exceptions.PessoaNaoCadastradaException;
import br.com.vermser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ObjectMapper objectMapper;

    public Contato converterContatoDTO (ContatoCreateDTO contatoCreateDTO){
       return objectMapper.convertValue(contatoCreateDTO, Contato.class);
    }

    public ContatoDTO converterContato (Contato contato){
        return objectMapper.convertValue(contato, ContatoDTO.class);
    }

    public ContatoDTO create (ContatoCreateDTO contato, Integer idPessoa) throws PessoaNaoCadastradaException {

        Pessoa pessoaCadastrada = pessoaService.findById(idPessoa);
        Contato contatoEntity = converterContatoDTO(contato);
        contatoEntity.setIdPessoa(idPessoa);
        contatoRepository.create(contatoEntity);
        log.info("Contato criado");
        return converterContato(contatoEntity);

    }

    public List<ContatoDTO> list (){
        return contatoRepository.list()
                .stream()
                .map(this::converterContato)
                .collect(Collectors.toList());
    }

    public ContatoDTO update (Integer id
            , ContatoCreateDTO contatoAtualizar) throws Exception {
        Contato contatoRecuperado = findByid(id);
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        contatoRecuperado.setTipoEndereco(contatoAtualizar.getTipoEndereco());
        log.info("Contato Atualizado");
        return converterContato(contatoRecuperado);
    }

    public void delete (Integer id) throws Exception {
        Contato contatoRecuperado = findByid(id);
        contatoRepository.list().remove(contatoRecuperado);
        log.info("Contato deletado");
    }

    public  List<ContatoDTO> listById (Integer id){
        return contatoRepository.list().stream()
                .map(this::converterContato)
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public Contato findByid(Integer id) throws PessoaNaoCadastradaException {
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new PessoaNaoCadastradaException("Contato não econtrada"));
    }

}
