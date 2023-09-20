package com.next2023.cloud_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.next2023.cloud_service.entities.Arquivos;

@Repository
public interface ArquivosRepository extends JpaRepository <Arquivos, Long> {
    
}
