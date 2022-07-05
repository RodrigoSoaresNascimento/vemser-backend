package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.entity.Contato;
import br.com.vermser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController (){
        contatoService = new ContatoService();
    }

    @PostMapping("/{idPessoa}")
    public Contato create (@RequestBody Contato contato){

        return contatoService.create(contato);
    }

    @GetMapping
    public List<Contato> list (){
        return contatoService.list();
    }

    @PutMapping("/{idContato}")
    public Contato update (@PathVariable("idContato") Integer id
            ,@RequestBody Contato contato) throws Exception {
        return contatoService.update(id, contato);
    }

    @DeleteMapping("/{idContato}")
    public void delete (@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }

    @GetMapping("/{idPessoa}")
    public  List<Contato> listById (@PathVariable("idPessoa") Integer id){
        return contatoService.listById(id);
    }

}
