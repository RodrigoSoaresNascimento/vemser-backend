package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.entity.Endereco;
import br.com.vermser.pessoaapi.exceptions.PessoaNaoCadastradaException;
import br.com.vermser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Endereco> create (@PathVariable("idPessoa") Integer idPessoa,
                                            @Valid @RequestBody Endereco endereco) throws PessoaNaoCadastradaException {

        return ResponseEntity.ok(enderecoService.create(idPessoa,endereco));
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> list (){
         return ResponseEntity.ok(enderecoService.list());
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> update (@PathVariable("idEndereco") Integer id
            , @Valid @RequestBody Endereco endereco) throws Exception {
        return ResponseEntity.ok(enderecoService.update(id, endereco));
    }

    @DeleteMapping("/{idEndereco}")
    public void delete (@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }

    @GetMapping("/{idEndereco}")
    public  ResponseEntity<List<Endereco>> listById (@PathVariable("idEndereco") Integer id){
        return ResponseEntity.ok(enderecoService.listById(id));
    }

    @GetMapping("/{idPessoa}/pessoa")
    public  ResponseEntity<List<Endereco>> listByPerson (@PathVariable("idPessoa") Integer id){
        return ResponseEntity.ok(enderecoService.listByPerson(id));
    }

}
