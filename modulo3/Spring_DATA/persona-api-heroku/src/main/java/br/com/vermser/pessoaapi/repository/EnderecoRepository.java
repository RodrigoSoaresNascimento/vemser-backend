package br.com.vermser.pessoaapi.repository;

import br.com.vermser.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

}
