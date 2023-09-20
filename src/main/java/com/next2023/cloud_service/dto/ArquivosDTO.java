package com.next2023.cloud_service.dto;

import java.util.Date;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.validation.constraints.NotBlank;


public class ArquivosDTO {


    private Long tamanhoArquivo;
    @NotBlank
    private String nomeArquivo;
   
    
}
