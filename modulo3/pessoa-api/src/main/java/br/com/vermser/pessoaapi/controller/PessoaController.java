package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.entity.Pessoa;
import br.com.vermser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Validated
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;
//    public PessoaController() {
//        this.pessoaService = new PessoaService();
//    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Pessoa> create (@RequestBody @Valid Pessoa pessoa){
        return ResponseEntity.ok(pessoaService.create(pessoa));

    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> list (){
        return ResponseEntity.ok(pessoaService.list());
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<Pessoa> update (@PathVariable("idPessoa") Integer id
            ,@RequestBody @Valid Pessoa pessoa) throws Exception {
        return ResponseEntity.ok(pessoaService.update(id, pessoa));
    }

    @DeleteMapping("/{idPessoa}")
    public void delete (@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }

    @GetMapping("/byname")
    public  ResponseEntity<List<Pessoa>> listByName (@RequestParam("nome=") String nome){
        return ResponseEntity.ok(pessoaService.listByName(nome));
    }

}
