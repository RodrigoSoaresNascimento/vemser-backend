package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vermser.pessoaapi.dto.EnderecoDTO;
import br.com.vermser.pessoaapi.entity.Endereco;
import br.com.vermser.pessoaapi.entity.Pessoa;
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

    public Endereco converterEnderecoDTO (EnderecoCreateDTO enderecoCreateDTO){
        return objectMapper.convertValue(enderecoCreateDTO, Endereco.class);
    }

    public EnderecoDTO converterEndereco (Endereco endereco){
        return objectMapper.convertValue(endereco, EnderecoDTO.class);
    }

    public EnderecoDTO create (Integer idPessoa, EnderecoCreateDTO endereco) throws PessoaNaoCadastradaException {

        Pessoa pessoaCadastrada = pessoaService.findById(idPessoa);
        Endereco enderecoEntity = converterEnderecoDTO(endereco);
        enderecoEntity.setIdPessoa(idPessoa);
        enderecoRepository.create(enderecoEntity);
        log.info("Endereço criado");
        EnderecoDTO enderecoDTO = converterEndereco(enderecoEntity);
        String tipodeMensagem = TipoDeMensagem.CREATE.getTipoDeMensagem();
        emailService.sendEmail(pessoaService.converterPessoa(pessoaCadastrada), enderecoDTO, tipodeMensagem);
        return enderecoDTO;

    }

    public List<EnderecoDTO> list () {
        return enderecoRepository.list()
                .stream()
                .map(this::converterEndereco)
                .collect(Collectors.toList());
    }

    public EnderecoDTO update (Integer id, EnderecoCreateDTO enderecoAtualizar) throws Exception {

        Endereco enderecoRecuperado = findById(id);
        Pessoa pessoaCadastrada = pessoaService.findById(enderecoRecuperado.getIdPessoa());
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
        emailService.sendEmail(pessoaService.converterPessoa(pessoaCadastrada), converterEndereco(enderecoRecuperado), tipodeMensagem);
        return converterEndereco(enderecoRecuperado);
    }

    public void delete (Integer id) throws Exception {
        Endereco enderecoRecuperado = findById(id);
        Pessoa pessoaCadastrada = pessoaService.findById(enderecoRecuperado.getIdPessoa());
        String tipodeMensagem = TipoDeMensagem.DELETE.getTipoDeMensagem();
        enderecoRepository.list().remove(enderecoRecuperado);
        emailService.sendEmail(pessoaService.converterPessoa(pessoaCadastrada), converterEndereco(enderecoRecuperado), tipodeMensagem);
        log.info("Endereço deletado");

    }

    public List<EnderecoDTO> listById (Integer id){
        return enderecoRepository.list().stream()
                .map(this::converterEndereco)
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByPerson (Integer id){
        return enderecoRepository.list().stream()
                .map(this::converterEndereco)
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public Endereco findById (Integer id) throws PessoaNaoCadastradaException {
        return enderecoRepository.list()
                .stream()
                .filter(endereco1 -> endereco1.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new PessoaNaoCadastradaException("Endereço não encontrado"));
    }

}
