package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.vermser.pessoaapi.service.DadosPessoaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dados-pessoais")
@Validated
public class DadosPessoisController {

    @Autowired
    private DadosPessoaisService dadosPessoaisService;

    @GetMapping
    public ResponseEntity<List<DadosPessoaisDTO>> getAll() {
        return ResponseEntity.ok(dadosPessoaisService.getAll());
    }

    @PostMapping
    public ResponseEntity<DadosPessoaisDTO> post(@RequestBody @Valid DadosPessoaisDTO dadosPessoaisDTO) {
        return ResponseEntity.ok(dadosPessoaisService.post(dadosPessoaisDTO));
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> put(@PathVariable("cpf") String cpf, @RequestBody @Valid DadosPessoaisDTO dadosPessoaisDTO) {
        return ResponseEntity.ok(dadosPessoaisService.put(cpf,dadosPessoaisDTO));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable("cpf") String cpf) {
        dadosPessoaisService.delete(cpf);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> get(@PathVariable("cpf") String cpf) {
        return ResponseEntity.ok(dadosPessoaisService.get(cpf));
    }
}
