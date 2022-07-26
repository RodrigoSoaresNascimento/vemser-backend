package br.com.vermser.pessoaapi.repository;


import br.com.vermser.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query(" select e"+
            "  from ENDERECO_PESSOA e ")
    Page<EnderecoEntity> relatorioCep(Pageable pageable);

    @Query(" select e "+
            "  from ENDERECO_PESSOA e " +
            "  where (:pais is null OR e.pais = :pais )")
    Page<EnderecoEntity> relatorioPais(Pageable pageable, @Param(value = "pais") String pais);

}
