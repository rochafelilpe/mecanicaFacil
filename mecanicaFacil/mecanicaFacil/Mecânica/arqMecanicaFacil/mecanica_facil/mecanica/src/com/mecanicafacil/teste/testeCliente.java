package com.mecanicafacil.teste;

import com.mecanicafacil.model.Cliente;
import com.mecanicafacil.repository.jdbc.ClienteDAO;
import java.util.List;
import com.mecanicafacil.repository.jdbc.ConexaoBanco;

public class testeCliente {
    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();

        // Criando um novo cliente para teste
        Cliente novo = new Cliente();
        novo.setNome("fabio");
        novo.setTelefone("5345345");
        novo.setEndereco("Rua do Concerto, 11");

        try {
            System.out.println("Tentando salvar cliente...");
            dao.salvar(novo);
           
            // 2. Listando para ver se salvou mesmo
            System.out.println("\nListando clientes do banco:");
            List<Cliente> lista = dao.listarTodos();
            for (Cliente c : lista) {
                System.out.println("Nome: " + c.getNome() + " | Tel: " + c.getTelefone());
            }
            
        } catch (Exception e) {
            System.err.println("ERRO NO TESTE: " + e.getMessage());
        }
    }
}