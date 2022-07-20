package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vermser.pessoaapi.dto.EnderecoDTO;
import br.com.vermser.pessoaapi.entity.EnderecoEntity;
import br.com.vermser.pessoaapi.entity.PessoaEntity;
import br.com.vermser.pessoaapi.enums.TipoDeMensagem;
import br.com.vermser.pessoaapi.exceptions.PessoaNaoCadastradaException;
import br.com.vermser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    public EnderecoEntity converterEnderecoDTO (EnderecoCreateDTO enderecoCreateDTO){
        return objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
    }

    public EnderecoDTO converterEndereco (EnderecoEntity endereco){
        return objectMapper.convertValue(endereco, EnderecoDTO.class);
    }

    public EnderecoDTO create (Integer idPessoa, EnderecoCreateDTO endereco) throws PessoaNaoCadastradaException {

        PessoaEntity pessoaCadastrada = pessoaService.findById(idPessoa);
        EnderecoEntity enderecoEntity = converterEnderecoDTO(endereco);
        enderecoEntity.getPessoas().add(pessoaCadastrada);
        enderecoRepository.save(enderecoEntity);
        log.info("Endereço criado");
        EnderecoDTO enderecoDTO = converterEndereco(enderecoEntity);
        String tipodeMensagem = TipoDeMensagem.CREATE.getTipoDeMensagem();
        emailService.sendEmail(pessoaService.converterPessoa(pessoaCadastrada), enderecoDTO, tipodeMensagem);
        return enderecoDTO;

    }

    public List<EnderecoDTO> list () {
        return enderecoRepository.findAll()
                .stream()
                .map(this::converterEndereco)
                .collect(Collectors.toList());
    }

    public EnderecoDTO update (Integer id, EnderecoCreateDTO enderecoAtualizar) throws Exception {

        EnderecoEntity enderecoRecuperado = findById(id);
        enderecoRecuperado.setPessoas(enderecoRecuperado.getPessoas());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());
        log.info("Endereço atualizado");
        String tipodeMensagem = TipoDeMensagem.UPDATE.getTipoDeMensagem();
       // emailService.sendEmail(pessoaService.converterPessoa(pessoaCadastrada), converterEndereco(enderecoRecuperado), tipodeMensagem);
        return converterEndereco(enderecoRepository.save(enderecoRecuperado));
    }

    public void delete (Integer id) throws Exception {
        EnderecoEntity enderecoRecuperado = findById(id);
        String tipodeMensagem = TipoDeMensagem.DELETE.getTipoDeMensagem();
        enderecoRepository.delete(enderecoRecuperado);
        //emailService.sendEmail(pessoaService.converterPessoa(pessoaCadastrada), converterEndereco(enderecoRecuperado), tipodeMensagem);
        log.info("Endereço deletado");

    }

    public List<EnderecoDTO> listById (Integer id){
        return enderecoRepository.findAll().stream()
                .map(this::converterEndereco)
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByPerson (Integer id){
        return enderecoRepository.findAll().stream()
                .map(this::converterEndereco)
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public EnderecoEntity findById (Integer id) throws PessoaNaoCadastradaException {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoCadastradaException("Endereço não encontrado"));
    }

}
