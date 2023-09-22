package com.next2023.cloud_service.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.next2023.cloud_service.dto.UsuarioDTO;
import com.next2023.cloud_service.entities.Usuario;
import com.next2023.cloud_service.repositories.UsuarioRepository;

import jakarta.validation.Valid;

@Component
public class UsuarioService {
    @Inject
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getuUsuarios() {

        return usuarioRepository.findAll();

    }
    
    public Usuario create(UsuarioDTO usuarioDTO){ 
        Usuario usuarioToPersist = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuarioToPersist);
        usuarioToPersist.setQtdeArquivosUtilizados(0);
        return usuarioRepository.save(usuarioToPersist);

    }
    
    public Usuario update(UsuarioDTO usuarioDTO){ 
        Usuario usuarioToPersist = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuarioToPersist);
         
        return usuarioRepository.save(usuarioToPersist);
    }

    public boolean delete(Long idUsuario){ 
        try {
           usuarioRepository.deleteById(idUsuario); 
        } catch (Exception e) {
           return false;
        }        
        return true; 
    }

    
}
