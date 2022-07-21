package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vermser.pessoaapi.dto.ContatoDTO;
import br.com.vermser.pessoaapi.entity.ContatoEntity;
import br.com.vermser.pessoaapi.entity.PessoaEntity;
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

    public ContatoEntity converterContatoDTO (ContatoCreateDTO contatoCreateDTO){
       return objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
    }

    public ContatoDTO converterContato (ContatoEntity contatoEntity){
        return objectMapper.convertValue(contatoEntity, ContatoDTO.class);
    }

    public ContatoDTO create (ContatoCreateDTO contato, Integer idPessoa) throws PessoaNaoCadastradaException {

        PessoaEntity pessoaCadastrada = pessoaService.findById(idPessoa);
        ContatoEntity contatoEntity = converterContatoDTO(contato);
        contatoEntity.setIdPessoa(idPessoa);
        contatoEntity.setPessoaEntity(pessoaCadastrada);
        contatoRepository.save(contatoEntity);
        log.info("ContatoEntity criado");
        return converterContato(contatoEntity);

    }

    public List<ContatoDTO> list (){
        return contatoRepository.findAll()
                .stream()
                .map(this::converterContato)
                .collect(Collectors.toList());
    }

    public ContatoDTO update (Integer id
            , ContatoCreateDTO contatoAtualizar) throws Exception {
        ContatoEntity contatoEntityRecuperado = findByid(id);
        contatoEntityRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoEntityRecuperado.setDescricao(contatoAtualizar.getDescricao());
        contatoEntityRecuperado.setTipoContato(contatoAtualizar.getTipoEndereco());
        log.info("ContatoEntity Atualizado");
        return converterContato(contatoRepository.save(contatoEntityRecuperado));
    }

    public void delete (Integer id) throws Exception {
        ContatoEntity contatoEntityRecuperado = findByid(id);
        contatoRepository.delete(contatoEntityRecuperado);
        log.info("ContatoEntity deletado");
    }

    public  List<ContatoDTO> listById (Integer id){
        return contatoRepository.findAll().stream()
                .map(this::converterContato)
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public ContatoEntity findByid(Integer id) throws PessoaNaoCadastradaException {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoCadastradaException("ContatoEntity não econtrada"));
    }

}
