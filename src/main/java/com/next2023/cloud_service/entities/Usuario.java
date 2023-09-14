package com.next2023.cloud_service.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    
    
    public Date getData_nasc() {
        return data_nasc;
    }
    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }
    
    public Usuario(Date data_nasc) {
        this.data_nasc = data_nasc;
    }
   
    public Usuario(Date data_nasc) {
        this.data_nasc = data_nasc;
    }
    private Date data_nasc;
    public Usuario(long id, String nome, String cpf, String date, String end, String plano,
            int qtd_arquivos_utilizados) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.end = end;
        this.plano = plano;
        this.qtd_arquivos_utilizados = qtd_arquivos_utilizados;
    }
    private String end;
    private String plano;
    private int qtd_arquivos_utilizados;
    public long getId() {
        return id;
    }
    public void setId(long id) {
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
    public String getDate() {
        return Date;
    }
    public void setDate(String date, String Date) {
        Date = date;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public String getPlano() {
        return plano;
    }
    public void setPlano(String plano) {
        this.plano = plano;
    }
    public int getQtd_arquivos_utilizados() {
        return qtd_arquivos_utilizados;
    }
    public void setQtd_arquivos_utilizados(int qtd_arquivos_utilizados) {
        this.qtd_arquivos_utilizados = qtd_arquivos_utilizados;
    }

}