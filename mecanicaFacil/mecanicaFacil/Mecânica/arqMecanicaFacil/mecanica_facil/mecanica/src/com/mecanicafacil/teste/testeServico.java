package com.mecanicafacil.teste;

import com.mecanicafacil.model.Servico;
import com.mecanicafacil.repository.jdbc.ServicoDAO;
import java.util.List;
import com.mecanicafacil.repository.jdbc.ConexaoBanco;
import java.time.LocalDate;

public class testeServico {
    public static void main(String[] args) {
        ServicoDAO dao = new ServicoDAO();

        // Criando um novo cliente para teste
        Servico novo = new Servico();
        novo.setDescricao("Troquei o motor do carro");
        novo.setValor(1100.00);
        novo.setData(LocalDate.now());
        
        
        //novo.setVeiculo(1);
        
        try {
            System.out.println("Tentando salvar cliente...");
            dao.registrar(novo);
           
            // 2. Listando para ver se salvou mesmo
            System.out.println("\nListando clientes do banco:");
            List<Servico> lista = dao.listarTodos();
            for (Servico s : lista) {
                System.out.println("Descricao: " + s.getDescricao() + " | Valor: " + s.getValor() + "| Data: " + s.getData());
            }
            
        } catch (Exception e) {
            System.err.println("ERRO NO TESTE: " + e.getMessage());
        }
    }
}
