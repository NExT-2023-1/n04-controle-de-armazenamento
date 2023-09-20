package com.next2023.cloud_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next2023.cloud_service.entities.Arquivos;
import com.next2023.cloud_service.repositories.ArquivosRepository;

@Service
public class ArquivosService {

    @Autowired
    private ArquivosRepository arquivosRepository;

    public List<Arquivos> listArquivos() {

       return arquivosRepository.findAll();
    
}

}