
package com.mecanicafacil.model;


public class Veiculo {
   private int id;
   private String placa; 
   private String modelo;
   private String marca;
   private String cor; 
   private int ano; 
   private Cliente cliente;
   
   //construtor DAO
   public Veiculo(){}
   
   //construtor
   public Veiculo(String modelo, String marca, String placa, String cor, int ano, Cliente cliente){
       this.modelo = modelo; 
       this.marca = marca; 
       this.placa = placa; 
       this.cor = cor; 
       this.ano = ano; 
       this.cliente = cliente;
   }
   
   //getters e setters 
   public int getId(){
       return id;
   }
   
   public String getModelo(){
       return modelo;
   }
   public void setModelo(){
       this.modelo = modelo;
   }
   
   public String getMarca(){
       return marca; 
   }
   public void setMarca(){
       this.marca = marca;
   }
   
   
   public String getCor(){
       return cor;
   }
   public void setCor(){
       this.cor = cor;
   }
   
   public int getAno() {
       return ano;
   }

   public void setAno(int ano) {
       this.ano = ano;
   }
   
   public Cliente getCliente(){
        return cliente; 
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
   
}


