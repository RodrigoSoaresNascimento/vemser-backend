package br.com.vermser.pessoaapi.service;

import br.com.vermser.pessoaapi.dto.UsuarioCreateDTO;
import br.com.vermser.pessoaapi.dto.UsuarioDTO;
import br.com.vermser.pessoaapi.entity.UsuarioEntity;
import br.com.vermser.pessoaapi.repository.Usuariorepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private Usuariorepository usuariorepository;

    @Autowired
    private ObjectMapper objectMapper;

    public Optional<UsuarioEntity> findById (Integer id){
        return usuariorepository.findById(id);
    }

    private String encodePassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }



    private UsuarioEntity converterUsuarioParaUsuarioDTO(UsuarioCreateDTO usuarioCreate){
        return objectMapper.convertValue(usuarioCreate, UsuarioEntity.class);
    }

    private UsuarioDTO converterUsuarioDTOParaUsuario(UsuarioEntity usuario){
        return objectMapper.convertValue(usuario, UsuarioDTO.class);
    }

    public UsuarioDTO create (UsuarioCreateDTO usuarioCreate){

        UsuarioEntity usuario = converterUsuarioParaUsuarioDTO(usuarioCreate);
        usuario.setSenha(encodePassword(usuario.getSenha()));
        usuario = usuariorepository.save(usuario);

        return converterUsuarioDTOParaUsuario(usuario);
    }

    public Optional<UsuarioEntity> findByLogin (String login){
        return usuariorepository.findByLogin(login);
    }
}
