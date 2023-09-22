package com.next2023.cloud_service.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.next2023.cloud_service.entities.Arquivos;

import com.next2023.cloud_service.repositories.ArquivosRepoisitory;
@Service
public class ArquivosService {
    @Inject
    private ArquivosRepoisitory arquivoRepository;
    @Inject
    private UsuarioService usuarioService;
    @Inject
    private AwsConfigService awsConfigService;
    public List<Arquivos> getArquivos() {

        return arquivoRepository.findAll();

    }
    
}
