package com.next2023.cloud_service.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Arquivos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tamanho", nullable = false)
    private Long tamanhoArquivo;
    @Column(name = "nome", nullable = false)
    private String nomeArquivo;
    
    @ManyToOne
    @JoinColumn(name="usuario_id", nullable = false) //Checar o nomenclatura dessa tabela com os demais integrantes
    @JsonBackReference //evitar que a busca entre em looping recursivo
    private Usuario usuario;

     //Construtores
    public Arquivos() {
    }
    public Arquivos(Long id, Long tamanhoArquivo, String nomeArquivo) {
        this.id = id;
        this.tamanhoArquivo = tamanhoArquivo;
        this.nomeArquivo = nomeArquivo;
    }

   
    
    public Long getId() {
        return id;
    }
    public Long getTamanhoArquivo() {
        return tamanhoArquivo;
    }
    public String getNomeArquivo() {
        return nomeArquivo;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public void setTamanhoArquivo(Long tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }
    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

    
//Incluir ManytoOne
}