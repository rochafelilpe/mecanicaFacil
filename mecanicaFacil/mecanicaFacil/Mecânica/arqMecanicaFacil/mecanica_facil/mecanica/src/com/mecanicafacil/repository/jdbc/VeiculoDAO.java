    
package com.mecanicafacil.repository.jdbc;

import com.mecanicafacil.model.Veiculo;
import com.mecanicafacil.model.Cliente;
import com.mecanicafacil.repository.VeiculoRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class VeiculoDAO implements VeiculoRepository {
    @Override
    public void registrar(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (placa, marca, modelo, ano, cor, cliente_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBanco.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getMarca());
            stmt.setString(3, veiculo.getModelo());
            stmt.setInt(4, veiculo.getAno());
            stmt.setString(5, veiculo.getCor());
            stmt.setInt(6, veiculo.getCliente().getId()); // pega o ID do objeto Cliente associado

            stmt.executeUpdate();
            System.out.println("Veículo registrado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao registrar veículo: " + e.getMessage());
        }
    }
    
    @Override
    public void atualizar(Veiculo veiculo) {
        //código que roda na base
        String sql = "UPDATE veiculo set placa=?, marca=?, modelo=?, ano=?, cor=? WHERE id=?";
        
        try (Connection conn = ConexaoBanco.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            //preenchendo os valores para atualizar na base
            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getMarca());
            stmt.setString(3, veiculo.getModelo());
            stmt.setInt(4, veiculo.getAno());
            stmt.setString(5, veiculo.getCor());
            stmt.setInt(6, veiculo.getId());
            
            
            //executa a atualização
            int linhasAfetadas = stmt.executeUpdate();
            
            //linha para ajudar nos testes
            System.out.println("Veiculo atualizado com sucesso!");
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar veiculo: " + e.getMessage());
        } 
    }
    
    @Override
    public void excluir(int id) {
        //código que roda na base
        String sql = "DELETE FROM veiculo WHERE id = ?";
        
        try (Connection conn = ConexaoBanco.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            //preenchendo o id para buscar e excluir
            stmt.setInt(1, id);
            //executa a exclusão
            int linhasAfetadas = stmt.executeUpdate();
            
            //linha para ajudar nos testes
            System.out.println("Exclusão realizada com sucesso");
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir cliente do banco: " + e.getMessage());
        } 
    }
    
    public List<Veiculo> buscarPorCliente(int idCliente) {
        String sql = "SELECT * FROM veiculo WHERE cliente_id = ?";
        List<Veiculo> veiculos = new ArrayList<>();

        try (Connection conn = ConexaoBanco.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Veiculo v = new Veiculo();
                    v.setPlaca(rs.getString("placa"));
                    v.setMarca(rs.getString("marca"));
                    v.setModelo(rs.getString("modelo"));
                    v.setAno(rs.getInt("ano"));
                    v.setCor(rs.getString("cor"));
                    
                    veiculos.add(v);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar veículos por cliente", e);
        }
        return veiculos;
    }
    
    public List<Veiculo> listarTodos() {
        String sql = "SELECT * FROM veiculo";
        List<Veiculo> veiculos = new ArrayList<>();

        try (Connection conn = ConexaoBanco.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Veiculo v = new Veiculo();
                v.setPlaca(rs.getString("placa"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setAno(rs.getInt("ano"));
                v.setCor(rs.getString("cor"));

                veiculos.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todos os veículos", e);
        }
        return veiculos;
    }
}
