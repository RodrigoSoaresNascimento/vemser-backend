package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vermser.pessoaapi.dto.ContatoDTO;
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
    public ResponseEntity<ContatoDTO> create (@PathVariable("idPessoa") Integer idPessoa,
                                           @Valid @RequestBody ContatoCreateDTO contato) throws PessoaNaoCadastradaException {

        return ResponseEntity.ok(contatoService.create(contato, idPessoa));
    }

    @GetMapping
    public ResponseEntity<List<ContatoDTO>> list (){
        return ResponseEntity.ok(contatoService.list());
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> update (@PathVariable("idContato") Integer id
            ,@Valid @RequestBody ContatoDTO contato) throws Exception {
        return ResponseEntity.ok(contatoService.update(id, contato));
    }

    @DeleteMapping("/{idContato}")
    public void delete (@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }

    @GetMapping("/{idPessoa}")
    public  ResponseEntity<List<ContatoDTO>> listById (@PathVariable("idPessoa") Integer id){
        return ResponseEntity.ok(contatoService.listById(id));
    }

}
