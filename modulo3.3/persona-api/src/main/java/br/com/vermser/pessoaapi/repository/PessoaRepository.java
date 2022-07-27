package br.com.vermser.pessoaapi.repository;

import br.com.vermser.pessoaapi.dto.PessoaCompostaDTO;
import br.com.vermser.pessoaapi.entity.PessoaEntity;
import br.com.vermser.pessoaapi.enums.TiposDeEndereco;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findByNomeContainsIgnoreCase(String nomePessoa);

    PessoaEntity findByCpf (String cpf);

    @Query(" select new br.com.vermser.pessoaapi.dto.PessoaCompostaDTO(" +
            " p.nome," +
            " p.email," +
            " c.numero," +
            " e.cep," +
            " e.cidade," +
            " e.estado," +
            " e.pais," +
            " pet.nome " +
            ")" +
            "  from PESSOA p " +
            "  left join p.contatos c " +
            "  left join p.enderecos e " +
            "  left join p.petEntity pet" +
            " where (:idPessoa is null OR p.idPessoa = :idPessoa )")
    List<PessoaCompostaDTO> relatorioPessoa(@Param("idPessoa") Integer idPessoa);

    @Query(" select p " +
            "  from PESSOA p " +
            "  join p.contatos cont " +  // ==== "  join CONTATO cont on (p.id_pessoa = c.id_pessoa)" +
            " where cont.tipoContato = :tipoContato ")
    List<PessoaEntity> listPessoasPorTipoContato(@Param("tipoContato") TiposDeEndereco tipoContato);
}
