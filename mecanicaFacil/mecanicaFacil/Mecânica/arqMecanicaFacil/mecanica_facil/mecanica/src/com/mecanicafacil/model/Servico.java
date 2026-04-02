package com.mecanicafacil.model;

import java.time.LocalDate;

public class Servico {
    private int id; 
    private String descricao; 
    private double valor; 
    private Veiculo veiculo; 
    private LocalDate data; 
    
    //construtor DAO
    public Servico(){}
    
    //construtor
    public Servico(int id, String descricao, double valor, Veiculo veiculo, LocalDate data){
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.veiculo = veiculo;
        this.data = data;
    }
    
    //getters e setters 
    public int getId(){
        return id;
    }
    public void setId(){
        this.id = id;
    }
    
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(){
        this.descricao = descricao;
    }
    
    public double getValor(){
        return valor;
    }
    public void setValor(){
        this.valor = valor;
    }
    
    public Veiculo getVeiculo(){
        return veiculo;
    }
    public void setVeiculo(){
        this.veiculo = veiculo;
    }
    
    public LocalDate getData(){
        return data;
    }
    public void setData(){
        this.data = data;
    }
}
