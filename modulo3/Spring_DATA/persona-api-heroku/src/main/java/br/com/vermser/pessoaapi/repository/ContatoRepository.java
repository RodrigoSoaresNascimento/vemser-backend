package br.com.vermser.pessoaapi.repository;

import br.com.vermser.pessoaapi.entity.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

}
