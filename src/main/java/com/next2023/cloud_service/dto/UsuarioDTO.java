package com.next2023.cloud_service.dto;

import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;

import com.next2023.cloud_service.entities.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {

    @NotBlank
    @Size(max = 30)
    private String nome;
    @NotBlank
    @CPF
    private String cpf;
    @NotBlank
    private String endereco;
    private Date dataNascimento;
    @NotBlank
    private char tipoPlano;
    @NotBlank
    private Long qtdeArquivosUtilizados;




}
