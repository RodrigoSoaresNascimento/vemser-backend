package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vermser.pessoaapi.dto.EnderecoDTO;
import br.com.vermser.pessoaapi.exceptions.PessoaNaoCadastradaException;
import br.com.vermser.pessoaapi.service.EnderecoService;
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
@RequestMapping("/endereco")
@Validated
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Operation(summary = "criar pessoa", description = "Cria um novo endereço")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "endereço criado"),
                    @ApiResponse(responseCode = "400", description = "Requisição invalida"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create (@PathVariable("idPessoa") Integer idPessoa,
                                               @Valid @RequestBody EnderecoCreateDTO endereco) throws PessoaNaoCadastradaException {

        return ResponseEntity.ok(enderecoService.create(idPessoa,endereco));
    }

    @Operation(summary = "listar endereços", description = "Lista todos os endereços do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços"),
                    @ApiResponse(responseCode = "400", description = "Endereço não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> list (){
         return ResponseEntity.ok(enderecoService.list());
    }

    @Operation(summary = "atualiza um endereço de uma pessoa", description = "atualiza um endereço")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereço atualizado"),
                    @ApiResponse(responseCode = "400", description = "Endereço não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update (@PathVariable("idEndereco") Integer id
            , @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
        return ResponseEntity.ok(enderecoService.update(id, endereco));
    }

    @Operation(summary = "deletar uma endereço", description = "deleta um endereço cadastrado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereço removido"),
                    @ApiResponse(responseCode = "400", description = "Endereço não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> delete (@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "busca um endereço", description = "realiza uma busca pelo id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereços encontrados"),
                    @ApiResponse(responseCode = "400", description = "Endereço não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idEndereco}")
    public  ResponseEntity<List<EnderecoDTO>> listById (@PathVariable("idEndereco") Integer id){
        return ResponseEntity.ok(enderecoService.listById(id));
    }

    @Operation(summary = "busca um endereço", description = "realiza uma busca de endereço pelo id de uma pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereços listados"),
                    @ApiResponse(responseCode = "400", description = "Endereço não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}/pessoa")
    public  ResponseEntity<List<EnderecoDTO>> listByPerson (@PathVariable("idPessoa") Integer id){
        return ResponseEntity.ok(enderecoService.listByPerson(id));
    }

}
