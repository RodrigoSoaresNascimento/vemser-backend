package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.dto.PetDTO;
import br.com.vermser.pessoaapi.service.PetService;
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
@RequestMapping("/pet")
@Validated
public class PetController {

    @Autowired
    private PetService service;

    @Operation(summary = "criar pet", description = "Cria um novo usuario")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "pet criada"),
                    @ApiResponse(responseCode = "400", description = "Requisição invalida"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/idPessoa")
    public ResponseEntity<PetDTO> create (@PathVariable("idPessoa") Integer idPessoa,
            @Valid @RequestBody PetDTO pet){
        return ResponseEntity.ok(service.create(idPessoa, pet));

    }

    @Operation(summary = "listar pets", description = "Lista todas as pets do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pets"),
                    @ApiResponse(responseCode = "400", description = "PetEntity não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public ResponseEntity<List<PetDTO>> list (){
        return ResponseEntity.ok(service.list());
    }

    @Operation(summary = "atualizar pet", description = "atualiza uma pet")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "pet atualizada"),
                    @ApiResponse(responseCode = "400", description = "PetEntity não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPet}")
    public ResponseEntity<PetDTO> update (@PathVariable("idPet") Integer id
            ,@Valid @RequestBody PetDTO pet) throws Exception {
        return ResponseEntity.ok(service.update(id, pet));
    }

    @Operation(summary = "deletar uma pet", description = "deleta uma pet")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "pet removida"),
                    @ApiResponse(responseCode = "400", description = "PetEntity não encontradoo"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPet}")
    public ResponseEntity<Void> delete (@PathVariable("idPet") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
