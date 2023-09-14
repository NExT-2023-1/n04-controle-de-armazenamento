package com.next2023.cloud_service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Arquivos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long tamanhoArquivo;
    @Column(nullable = false)
    private String nomeArquivo;

//Incluir ManytoOne

//Incluir GETs e SETs

    
}

