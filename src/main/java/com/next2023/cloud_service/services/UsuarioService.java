package com.next2023.cloud_service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next2023.cloud_service.dto.UsuarioDTO;
import com.next2023.cloud_service.entities.Usuario;
import com.next2023.cloud_service.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listUsuarios(){
       return usuarioRepository.findAll();

       /*  List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();

        for (Usuario usuario : usuarios) {

            UsuarioDTO usuarioDTO = new UsuarioDTO();
            BeanUtils.copyProperties(usuario, usuarioDTO);
            usuariosDTO.add(usuarioDTO);
        }

        return usuariosDTO;  
*/

}

}
