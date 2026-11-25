
package mecanica;

import java.util.Date;


public class Servico {
    private int id;
    private String descricao;
    private Date data;
    private double valor;
    private String observacoes;
    private Veiculo veiculo; // Associação com a classe Veiculo

    
    //Construtor
    public Servico(int id, String descricao, Date data, double valor, String observacoes, Veiculo veiculo) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.observacoes = observacoes;
        this.veiculo = veiculo;
    }
    
    //getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
}
