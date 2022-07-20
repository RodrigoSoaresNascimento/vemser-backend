package br.com.vermser.pessoaapi.controller;

import br.com.vermser.pessoaapi.entity.ProfessorEntity;
import br.com.vermser.pessoaapi.entity.ProfessorPk;
import br.com.vermser.pessoaapi.repository.ProfessorRepository;
import br.com.vermser.pessoaapi.service.ProfessorService;
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
    private ProfessorService service;

    @GetMapping
    public List<ProfessorEntity> findAll(){
        return service.list();
    }

    @PostMapping
    public ProfessorEntity create(@Valid @RequestBody ProfessorEntity professor){
        service.create(professor);
        return professor;
    }

}
