package com.next2023.cloud_service.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.next2023.cloud_service.entities.Usuario;
import com.next2023.cloud_service.repositories.UsuarioRepository;

@Component
public class UsuarioService {
    @Inject
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getuUsuarios() {
        return usuarioRepository.findAll();

    }
    

    
    
}
