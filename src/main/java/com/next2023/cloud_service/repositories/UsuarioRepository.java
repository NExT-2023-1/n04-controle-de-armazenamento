package com.next2023.cloud_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.next2023.cloud_service.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    
}
