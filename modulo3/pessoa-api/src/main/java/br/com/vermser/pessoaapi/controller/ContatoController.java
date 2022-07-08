package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.entity.Contato;
import br.com.vermser.pessoaapi.exceptions.PessoaNaoCadastradaException;
import br.com.vermser.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

//    public ContatoController (){
//        contatoService = new ContatoService();
//    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Contato> create (@PathVariable("idPessoa") Integer idPessoa,
                                  @RequestBody @Valid Contato contato) throws PessoaNaoCadastradaException {

        return ResponseEntity.ok(contatoService.create(contato, idPessoa));
    }

    @GetMapping
    public ResponseEntity<List<Contato>> list (){
        return ResponseEntity.ok(contatoService.list());
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<Contato> update (@PathVariable("idContato") Integer id
            ,@RequestBody @Valid Contato contato) throws Exception {
        return ResponseEntity.ok(contatoService.update(id, contato));
    }

    @DeleteMapping("/{idContato}")
    public void delete (@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }

    @GetMapping("/{idPessoa}")
    public  ResponseEntity<List<Contato>> listById (@PathVariable("idPessoa") Integer id){
        return ResponseEntity.ok(contatoService.listById(id));
    }

}
