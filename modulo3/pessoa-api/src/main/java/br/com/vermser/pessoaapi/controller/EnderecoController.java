package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.entity.Endereco;
import br.com.vermser.pessoaapi.exceptions.PessoaNaoCadastradaException;
import br.com.vermser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/{idPessoa}")
    public Endereco create (@PathVariable("idPessoa") Integer idPessoa,
                            @RequestBody Endereco endereco) throws PessoaNaoCadastradaException {

        return enderecoService.create(idPessoa,endereco);
    }

    @GetMapping
    public List<Endereco> list (){
        return enderecoService.list();
    }

    @PutMapping("/{idEndereco}")
    public Endereco update (@PathVariable("idEndereco") Integer id
            ,@RequestBody Endereco endereco) throws Exception {
        return enderecoService.update(id, endereco);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete (@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }

    @GetMapping("/{idEndereco}")
    public  List<Endereco> listById (@PathVariable("idEndereco") Integer id){
        return enderecoService.listById(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public  List<Endereco> listByPerson (@PathVariable("idPessoa") Integer id){
        return enderecoService.listById(id);
    }

}
