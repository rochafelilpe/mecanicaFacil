
package com.mecanicafacil.repository.jdbc;

import com.mecanicafacil.model.Servico;
import com.mecanicafacil.repository.ServicoRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


public class ServicoDAO implements ServicoRepository{
    
    @Override
    public void registrar(Servico servico) {
        //Servico é obrigatório (Validação simples antes de ir ao banco)
        if (servico.getDescricao() == null || servico.getDescricao().isEmpty()) throw new RuntimeException("Descrição obrigatória.");
        if (servico.getVeiculo() == null) throw new RuntimeException("Veículo obrigatório.");
        if (servico.getValor() == 0) throw new RuntimeException("Valor obrigatório.");
        if (servico.getData() == null) throw new RuntimeException("Data obrigatória.");

        String sql = "INSERT INTO servico (descricao, valor, data, veiculo) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBanco.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, servico.getDescricao());
            stmt.setDouble(3, servico.getValor());
            stmt.setDate(4, Date.valueOf(servico.getData()));
            stmt.setInt(2, servico.getVeiculo().getId());
            
            
            stmt.executeUpdate();
            
            System.out.println("Servico cadastrado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar serviço no banco: " + e.getMessage());
        }
    }
    
    @Override
    public List<Servico> listarTodos() {
        List<Servico> servicos = new ArrayList<>();
        String sql = "SELECT * FROM servico";

        try (Connection conn = ConexaoBanco.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Servico s = new Servico();
                s.setId(rs.getInt("id"));
                s.setDescricao(rs.getString("descricao"));
                s.setValor(rs.getDouble("valor"));
                s.setData(rs.getDate("data").toLocalDate());
                    
                servicos.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar clientes: " + e.getMessage());
        }
        return servicos;
    }   
    
        @Override
    public List<Servico> listarPorCliente(String nomeCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
