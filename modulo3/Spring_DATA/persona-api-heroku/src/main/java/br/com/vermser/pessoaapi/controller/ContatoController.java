package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vermser.pessoaapi.dto.ContatoDTO;
import br.com.vermser.pessoaapi.exceptions.PessoaNaoCadastradaException;
import br.com.vermser.pessoaapi.service.ContatoService;
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
@RequestMapping("/contato")
@Validated
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

//    public ContatoController (){
//        contatoService = new ContatoService();
//    }

    @Operation(summary = "cria um contato", description = " cria um novo contato em uma pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "contato criado"),
                    @ApiResponse(responseCode = "400", description = "Requisição invalida"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoDTO> create (@PathVariable("idPessoa") Integer idPessoa,
                                           @Valid @RequestBody ContatoCreateDTO contato) throws PessoaNaoCadastradaException {

        return ResponseEntity.ok(contatoService.create(contato, idPessoa));
    }

    @Operation(summary = "lista os contatos", description = "lista os contatos no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "contatos listados"),
                    @ApiResponse(responseCode = "400", description = "ContatoEntity não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public ResponseEntity<List<ContatoDTO>> list (){
        return ResponseEntity.ok(contatoService.list());
    }

    @Operation(summary = "atualiza um contato", description = "atualiza um contato existente em uma pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "contato atualizada"),
                    @ApiResponse(responseCode = "400", description = "ContatoEntity não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> update (@PathVariable("idContato") Integer id
            ,@Valid @RequestBody ContatoCreateDTO contato) throws Exception {
        return ResponseEntity.ok(contatoService.update(id, contato));
    }

    @Operation(summary = "deleta um contato", description = "deleta um contato por id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "contato deletada"),
                    @ApiResponse(responseCode = "400", description = "ContatoEntity não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete (@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "busca um contato", description = "busca um contato existente")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "busca bem sucessida"),
                    @ApiResponse(responseCode = "400", description = "ContatoEntity não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}")
    public  ResponseEntity<List<ContatoDTO>> listById (@PathVariable("idPessoa") Integer id){
        return ResponseEntity.ok(contatoService.listById(id));
    }

}
