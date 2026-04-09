
package com.mecanicafacil.repository.jdbc;

import com.mecanicafacil.model.Cliente;
import com.mecanicafacil.repository.ClienteRepository;
import com.mecanicafacil.repository.jdbc.ConexaoBanco;

import java.sql.*;
import java.util.ArrayList; 
import java.util.List;


public class ClienteDAO implements ClienteRepository {

    @Override
    public void salvar(Cliente cliente) {
        //Nome é obrigatório (Validação simples antes de ir ao banco)
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) throw new RuntimeException("Descrição obrigatória.");
        
        String sql = "INSERT INTO cliente (nome, telefone, endereco) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBanco.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEndereco());
            
            stmt.executeUpdate();
            
            System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar cliente no banco: " + e.getMessage());
        }
    }
    
    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
                
                clientes.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar clientes: " + e.getMessage());
        }
        return clientes;
    }
    
    @Override
    public void atualizar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public void excluir(String placa) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Cliente buscarPorPlaca(String placa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
