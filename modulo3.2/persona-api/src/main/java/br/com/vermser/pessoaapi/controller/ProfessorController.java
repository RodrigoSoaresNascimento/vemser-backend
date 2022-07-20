package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.entity.ProfessorEntity;
import br.com.vermser.pessoaapi.entity.ProfessorPk;
import br.com.vermser.pessoaapi.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/professor")
@Validated
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @GetMapping
    public List<ProfessorEntity> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public ProfessorEntity create(@Valid @RequestBody ProfessorEntity professor){
        repository.save(professor);
        return professor;
    }

    @PutMapping("{idProfessor}/e/{idUniversidade}")
    public ProfessorEntity update(ProfessorPk professorPk, ProfessorEntity professor){
        ProfessorEntity professorAtualizar = professor;
        professorAtualizar.setProfessorPk(professorPk);
        professorAtualizar.setNome(professor.getNome());
        professorAtualizar.setSalario(professor.getSalario());
        return professorAtualizar;

    }

}
