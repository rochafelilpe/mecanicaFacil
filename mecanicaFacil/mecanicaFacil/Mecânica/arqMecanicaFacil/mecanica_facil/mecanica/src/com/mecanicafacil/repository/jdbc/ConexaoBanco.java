
package com.mecanicafacil.repository.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBanco {
 
    //dados do banco
    private static final String URL = "jdbc:mysql://localhost:3306/mecanica_facil";
    private static final String USUARIO = "felipe";
    private static final String SENHA = "root";
    
    //classes que cria a conexão com o banco de dados
    public static Connection getConexao() throws SQLException {
        try {
            // carrega o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            System.out.println("TUDO CERTO NA CONEXAO");
            
            return DriverManager.getConnection(URL, USUARIO, SENHA);
            
            
            
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL não encontrado: " + e.getMessage());
        }
    }
}

