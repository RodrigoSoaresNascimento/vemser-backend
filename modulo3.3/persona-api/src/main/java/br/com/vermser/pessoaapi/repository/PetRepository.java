package br.com.vermser.pessoaapi.repository;

import br.com.vermser.pessoaapi.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PetRepository extends JpaRepository<PetEntity, Integer> {

}
