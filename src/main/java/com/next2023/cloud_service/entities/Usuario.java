package com.next2023.cloud_service.entities;

import java.sql.Date;
import java.util.List;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cpf",nullable = false)
    private String cpf;
    @Column(name = "data_nasc") // Considerando campo não obrigatório, apenas para fins didáticos de teste
    private Date dataNascimento;
    @Column(name = "endereco",nullable = false)
    private String endereco;
    @Column(name = "plano", nullable = false)
    private String tipoPlano;  //A, B, ou C - Plus: criar domínio para essa variável
    @Column(name = "qtd_arquivos_utilizados", nullable = false)
    private Integer qtdeArquivosUtilizados;

         
    //Cascade serve para realizar a ação, simultaneamente, no usuario e todos os arquivos (nesse caso a única entidade existe)
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "usuario") //Cascade ALL: já engloba todos os tipos (presist, delete)
    private List<Arquivos> arquivos;

    //Construtores - sem usar o lombok
    public Usuario() {
    }

    public Usuario(Long id, String nome, String cpf, Date dataNascimento, String endereco, String tipoPlano,
            Integer qtdeArquivosUtilizados) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.tipoPlano = tipoPlano;
        this.qtdeArquivosUtilizados = qtdeArquivosUtilizados;

       
    }


    
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getTipoPlano() {
        return tipoPlano;
    }
    public Integer getQtdeArquivosUtilizados() {
        return qtdeArquivosUtilizados;
    }
    
    
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setTipoPlano(String tipoPlano) {
        this.tipoPlano = tipoPlano;
    }
    public void setQtdeArquivosUtilizados(Integer qtdeArquivosUtilizados) {
        this.qtdeArquivosUtilizados = qtdeArquivosUtilizados;
    }

    public List<Arquivos> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivos> arquivos) {
        this.arquivos = arquivos;
    }

    public void incrementarQtdeArquivosUtilizados(){
        this.qtdeArquivosUtilizados++;
    }

    
                

//Incluir OneToMany  




}


