package br.com.vermser.pessoaapi.repository;

import br.com.vermser.pessoaapi.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    Optional<UsuarioEntity> findByLogin (String login);
}
