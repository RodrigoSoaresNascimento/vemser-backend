package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vermser.pessoaapi.dto.PessoaDTO;
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

    @PostMapping
    public ResponseEntity<PessoaDTO> create (@Valid @RequestBody PessoaCreateDTO pessoa){
        return ResponseEntity.ok(pessoaService.create(pessoa));

    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> list (){
        return ResponseEntity.ok(pessoaService.list());
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> update (@PathVariable("idPessoa") Integer id
            ,@Valid @RequestBody PessoaDTO pessoa) throws Exception {
        return ResponseEntity.ok(pessoaService.update(id, pessoa));
    }

    @DeleteMapping("/{idPessoa}")
    public void delete (@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }

    @GetMapping("/byname")
    public  ResponseEntity<List<PessoaDTO>> listByName (@RequestParam("nome=") String nome){
        return ResponseEntity.ok(pessoaService.listByName(nome));
    }

}
