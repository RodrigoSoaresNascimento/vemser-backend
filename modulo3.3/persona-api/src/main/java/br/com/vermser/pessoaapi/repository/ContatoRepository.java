package br.com.vermser.pessoaapi.repository;



import br.com.vermser.pessoaapi.entity.ContatoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;



@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {


    @Query(" select c"+
            "  from CONTATO c "
           )
    Page<ContatoEntity> relatorioPessoa(Pageable pageable);

}
