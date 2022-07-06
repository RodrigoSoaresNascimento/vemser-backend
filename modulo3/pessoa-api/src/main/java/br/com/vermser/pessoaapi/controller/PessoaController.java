package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.entity.Pessoa;
import br.com.vermser.pessoaapi.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController() {
        this.pessoaService = new PessoaService();
    }

    @PostMapping("/{idPessoa}")
    public Pessoa create (@RequestBody Pessoa pessoa){
        return pessoaService.create(pessoa);

    }

    @GetMapping
    public List<Pessoa> list (){
        return pessoaService.list();
    }

    @PutMapping("/{idPessoa}")
    public Pessoa update (@PathVariable("idPessoa") Integer id
            ,@RequestBody Pessoa pessoa) throws Exception {
        return pessoaService.update(id, pessoa);
    }

    @DeleteMapping("/{idPessoa}")
    public void delete (@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }

    @GetMapping("/byname")
    public  List<Pessoa> listByName (@RequestParam("nome=") String nome){
        return pessoaService.listByName(nome);
    }

}
