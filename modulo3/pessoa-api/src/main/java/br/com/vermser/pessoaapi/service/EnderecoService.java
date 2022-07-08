package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.entity.Endereco;
import br.com.vermser.pessoaapi.exceptions.PessoaNaoCadastradaException;
import br.com.vermser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;

    private AtomicInteger COUNTER = new AtomicInteger();

    public Endereco create (Integer idPessoa, Endereco endereco) throws PessoaNaoCadastradaException {

        boolean cepValido = endereco.getCep().length() == 9;

        if(cepValido){

            boolean pessoaCadastrda = pessoaService.findById(idPessoa);

            if(pessoaCadastrda){
                endereco.setIdPessoa(idPessoa);
                endereco.setIdEndereco(COUNTER.incrementAndGet());
                enderecoRepository.list().add(endereco);
                return endereco;
            }else{
                try {
                    throw new PessoaNaoCadastradaException("Pessoa não cadastrada");
                } catch (PessoaNaoCadastradaException e) {
                    throw new RuntimeException(e);
                }
            }
        }else {
            throw new PessoaNaoCadastradaException("Informações incompletas retorne ao cadastro");
        }

    }

    public List<Endereco> list () {
        return enderecoRepository.list();
    }

    public Endereco update (Integer id, Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = findById (id);
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());
        return enderecoRecuperado;
    }

    public void delete (Integer id) throws Exception {
        Endereco enderecoRecuperado = findById(id);
        enderecoRepository.list().remove(enderecoRecuperado);

    }

    public List<Endereco> listById (Integer id){
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .collect(Collectors.toList());
    }

    public List<Endereco> listByPerson (Integer id){
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public Endereco findById (Integer id) throws Exception {
        Endereco enderecoRecuperado = enderecoRepository.list()
                .stream()
                .filter(endereco1 -> endereco1.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não econtrada"));

        return  enderecoRecuperado;
    }

}
