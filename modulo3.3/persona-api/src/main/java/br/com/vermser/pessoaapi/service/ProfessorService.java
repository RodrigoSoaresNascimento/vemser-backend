package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.entity.ProfessorEntity;
import br.com.vermser.pessoaapi.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository repository;

    public ProfessorEntity create(ProfessorEntity professor){
        repository.save(professor);
        return professor;
    }

    public List<ProfessorEntity> list(){
        return repository.findAll();
    }
}
