package com.next2023.cloud_service.dto;

import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;

import com.next2023.cloud_service.entities.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {


   
    private Long id;
    @Size(max = 30)
    private String nome;
    @NotNull(message = "Please enter CPF")
    @CPF
    private String cpf;
    @NotNull(message = "Campo Obrigatório")
    private String endereco;
    private Date dataNascimento;
    @NotNull(message = "Campo Obrigatório")
    private String tipoPlano;
    private Integer qtdeArquivosUtilizados;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getTipoPlano() {
        return tipoPlano;
    }
    public void setTipoPlano(String tipoPlano) {
        this.tipoPlano = tipoPlano;
    }
    public Integer getQtdeArquivosUtilizados() {
        return qtdeArquivosUtilizados;
    }
    public void setQtdeArquivosUtilizados(Integer qtdeArquivosUtilizados) {
        this.qtdeArquivosUtilizados = qtdeArquivosUtilizados;
    }


}
