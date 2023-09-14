package com.next2023.cloud_service.entities;

import java.sql.Date;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity


public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private Date dataNascimento;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private char tipoPlano;  //A, B, ou C
    @Column(nullable = false)
    private Long qtdeArquivosUtilizados;


//Checar arquivo de Emmanuel e nomear as colunas de forma idêntica

//Incluir OneToMany  

//Incluir GETs e SETs


}


