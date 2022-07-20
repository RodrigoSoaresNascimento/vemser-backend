package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.dto.*;
import br.com.vermser.pessoaapi.entity.EnderecoEntity;
import br.com.vermser.pessoaapi.entity.PessoaEntity;
import br.com.vermser.pessoaapi.entity.PetEntity;
import br.com.vermser.pessoaapi.exceptions.PessoaNaoCadastradaException;
import br.com.vermser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    public PessoaEntity converterPessoaDTO (PessoaCreateDTO pessoaDTO) {
        return objectMapper.convertValue(pessoaDTO, PessoaEntity.class);
    }

    public PessoaDTO converterPessoa (Object pessoa){
        return objectMapper.convertValue(pessoa, PessoaDTO.class);
    }

    public PessoaDTO create (PessoaCreateDTO pessoa) {

        PessoaEntity pessoaEntity = converterPessoaDTO(pessoa);
        pessoaEntity = pessoaRepository.save(pessoaEntity);
        PessoaDTO pessoaDTO = converterPessoa(pessoaEntity);
        pessoaDTO.setIdPessoa(pessoaEntity.getIdPessoa());
        emailService.novoCadastroSimpleMessage(pessoaDTO);
        log.info("PessoaEntity criada");
        return pessoaDTO;
    }

    public List<PessoaDTO> list (){
        return pessoaRepository.findAll()
                .stream()
                .map(this::converterPessoa)
                .collect(Collectors.toList());
    }

    public PessoaDTO update (Integer id
    , PessoaCreateDTO pessoaAtualizar) throws Exception {

        PessoaEntity pessoaRecuperada = findById(id);
        pessoaRecuperada.setIdPessoa(id);
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaRecuperada.setEmail(pessoaAtualizar.getEmail());
        log.info("PessoaEntity atualizada");

        emailService.updateSimpleMessage(converterPessoa(pessoaRecuperada));
        return converterPessoa(pessoaRepository.save(pessoaRecuperada));
    }

    public void delete (Integer id) throws Exception {
        PessoaEntity pessoaRecuperada = findById(id);
        log.info("PessoaEntity removida!");
        pessoaRepository.delete(pessoaRecuperada);
        emailService.deleteSimpleMessage(converterPessoa(pessoaRecuperada));
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.findByNomeContainsIgnoreCase(nome)
                .stream()
                .map(this::converterPessoa)
                .collect(Collectors.toList());
    }

    public PessoaDTO listByCpf(String cpf) {
        return converterPessoa(pessoaRepository.findByCpf(cpf));
    }

    public PessoaEntity findById (Integer id) throws PessoaNaoCadastradaException {
        PessoaEntity pessoaRecuperada = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoCadastradaException("PessoaEntity não econtrada"));
        return pessoaRecuperada;
    }

    public List<PessoaContatoDTO> listContatos (Integer idPessoa){

        if (idPessoa == null) {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaContatoDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaContatoDTO.class);
                        pessoaDTO.setContatosDTO(pessoaEntity.getContatos().stream()
                                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class)).toList());
                        return pessoaDTO;
                    }).toList();
        } else {
            return pessoaRepository.findById(idPessoa)
                    .map(pessoaEntity -> {
                        PessoaContatoDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaContatoDTO.class);
                        pessoaDTO.setContatosDTO(pessoaEntity.getContatos().stream()
                                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class)).toList());
                        return pessoaDTO;
                    }).stream().toList();
        }

    }

    public List<PessoaEnderecoDTO> listEnderecos (Integer idPessoa){

        if (idPessoa == null) {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaEnderecoDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaEnderecoDTO.class);
                        pessoaDTO.setEnderecosDTO(pessoaEntity.getEnderecos().stream()
                                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .toList());
                        return pessoaDTO;
                    }).toList();
        } else {
            return pessoaRepository.findById(idPessoa)
                    .map(pessoaEntity -> {
                        PessoaEnderecoDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaEnderecoDTO.class);
                        pessoaDTO.setEnderecosDTO(pessoaEntity.getEnderecos().stream()
                                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class)).toList());
                        return pessoaDTO;
                    }).stream().toList();
        }

    }

    public List<PessoaPetDTO> buscarPet (Integer idPessoa){

        if (idPessoa == null) {
            return pessoaRepository.findAll()
                    .stream()
                    .map(pessoaEntity -> {
                        PessoaPetDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaPetDTO.class);
                        pessoaDTO.setPetDTO(objectMapper.convertValue(pessoaEntity.getPet(), PetDTO.class));
                        return pessoaDTO;
                    }).toList();
        } else {
            return pessoaRepository.findById(idPessoa)
                    .map(pessoaEntity -> {
                        PessoaPetDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaPetDTO.class);
                        pessoaDTO.setPetDTO(objectMapper.convertValue(pessoaEntity.getPet(), PetDTO.class));
                        return pessoaDTO;
                    }).stream().toList();
        }
    }

}
