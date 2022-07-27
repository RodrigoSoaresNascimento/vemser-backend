package br.com.vermser.pessoaapi.repository;

import br.com.vermser.pessoaapi.entity.ProfessorEntity;
import br.com.vermser.pessoaapi.entity.ProfessorPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, ProfessorPk> {
}
