
package com.mecanicafacil.repository.jdbc;

import com.mecanicafacil.model.Cliente;
import com.mecanicafacil.repository.ClienteRepository;
import com.mecanicafacil.repository.jdbc.ConexaoBanco;

import java.sql.*;
import java.util.ArrayList; 
import java.util.List;


public class ClienteDAO implements ClienteRepository {

    @Override
    public int salvar(Cliente cliente) {
        //checa se "nome" é vazio ou nulo
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) throw new RuntimeException("Nome é um campo obrigatório.");
        
        String sql = "INSERT INTO cliente (nome, telefone, endereco) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBanco.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEndereco());
            
            stmt.executeUpdate();
            
            // Recupera o ID gerado
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); 
                }
            }
            
            System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar cliente no banco: " + e.getMessage());
        }
        
        return -1; 
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
                c.setId(rs.getInt("id"));
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
        //código que roda na base
        String sql = "UPDATE cliente set nome=?, telefone=?, endereco=? WHERE id;?";
        
        try (Connection conn = ConexaoBanco.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            //preenchendo os valores para atualizar na base
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEndereco());
            stmt.setInt(4, cliente.getId()); 
            
            //executa a atualização
            int linhasAfetadas = stmt.executeUpdate();
            
            //linha para ajudar nos testes
            System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso!");
            
            if (linhasAfetadas > 0) {
                System.out.println("Dados do cliente " + cliente.getNome() + " atualizados com sucesso!");
            } else {
                System.out.println("Nenhum cliente encontrado com o ID: " + cliente.getId());
            }
            
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar cliente no banco: " + e.getMessage());
        } 
    }
    
    @Override
    public void excluir(int id) {
        //código que roda na base
        String sql = "DELETE FROM cliente WHERE id = ?";
        
        try (Connection conn = ConexaoBanco.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            //preenchendo o id para buscar e excluir
            stmt.setInt(1, id); 
            
            //executa a exclusão
            int linhasAfetadas = stmt.executeUpdate();
            
            //linha para ajudar nos testes
            System.out.println("Exclusão realizada com sucesso!");
            
            if (linhasAfetadas > 0) {
                System.out.println("Cliente com id: " + id + " excluido com sucesso!");
            } else {
                System.out.println("Nenhum cliente encontrado com o ID: " + id);
            }
            
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir cliente do banco: " + e.getMessage());
        } 
    }
    
    @Override
    public int buscarIdPorTelefone(String telefone){
        String sql = "SELECT id FROM cliente WHERE telefone = ?";
        //tenta se conectar na base
        try(Connection conn = ConexaoBanco.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            //atribui o valor de telefone
            stmt.setString(1, telefone);
            
            //se tiver algum resultado com o valor informado
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    //pega o id
                    return rs.getInt("id");
                }
            }
        }
        catch(SQLException e){
            throw new RuntimeException("Erro ao buscar cliente por telefone", e);
        }
        
        return -1;
    }
}
