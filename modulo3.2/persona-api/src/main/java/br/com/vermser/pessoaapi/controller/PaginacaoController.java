package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.entity.ContatoEntity;
import br.com.vermser.pessoaapi.entity.EnderecoEntity;
import br.com.vermser.pessoaapi.repository.ContatoRepository;
import br.com.vermser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paginacao")
@Validated
public class PaginacaoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/endereco-paginado-cep")
    public Page<EnderecoEntity> getCepPaginado(Integer pagina, Integer quantidadeRegistros){
        Sort ordenacao = Sort.by("cep").descending();
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, ordenacao);
        return enderecoRepository.relatorioCep(pageable);
    }

    @GetMapping("/contato-paginado")
    public Page<ContatoEntity> getRelatorioPaginado(Integer pagina, Integer quantidadeRegistros){
        Sort ordenacao = Sort.by("descricao").descending();
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, ordenacao);

        return contatoRepository.relatorioPessoa(pageable);
    }

    @GetMapping("/endereco-pais")
    public Page<EnderecoEntity> getPais(Integer pagina, Integer quantidadeRegistros, String pais){
        Sort ordenacao = Sort.by("pais").descending();
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, ordenacao);

        return enderecoRepository.relatorioPais(pageable, pais);
    }

}
