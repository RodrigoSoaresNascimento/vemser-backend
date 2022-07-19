package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vermser.pessoaapi.dto.PessoaDTO;
import br.com.vermser.pessoaapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Operation(summary = "criar pessoa", description = "Cria um novo usuario")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "pessoa criada"),
                    @ApiResponse(responseCode = "400", description = "Requisição invalida"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping
    public ResponseEntity<PessoaDTO> create (@Valid @RequestBody PessoaCreateDTO pessoa){
        return ResponseEntity.ok(pessoaService.create(pessoa));

    }

    @Operation(summary = "listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "400", description = "PessoaEntity não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public ResponseEntity<List<PessoaDTO>> list (){
        return ResponseEntity.ok(pessoaService.list());
    }

    @Operation(summary = "atualizar pessoa", description = "atualiza uma pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "pessoa atualizada"),
                    @ApiResponse(responseCode = "400", description = "PessoaEntity não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> update (@PathVariable("idPessoa") Integer id
            ,@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        return ResponseEntity.ok(pessoaService.update(id, pessoa));
    }

    @Operation(summary = "deletar uma pessoa", description = "deleta uma pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "pessoa removida"),
                    @ApiResponse(responseCode = "400", description = "PessoaEntity não encontradoo"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete (@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "busca uma pessoa", description = "realiza uma busca pelo nome")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "pessoas encontradas"),
                    @ApiResponse(responseCode = "400", description = "PessoaEntity não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/byname")
    public  ResponseEntity<List<PessoaDTO>> listByName (@RequestParam("nome=") String nome){
        return ResponseEntity.ok(pessoaService.listByName(nome));
    }

}
