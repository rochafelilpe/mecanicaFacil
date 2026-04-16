package com.mecanicafacil.view;

import com.mecanicafacil.model.Cliente;
import com.mecanicafacil.repository.jdbc.ClienteDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TelaConsultaGeral extends javax.swing.JPanel {

    
    public TelaConsultaGeral() {
        initComponents();
        preencherTabelaClientes(""); //carrega todos os clientes do banco
    }
    
    private void preencherTabelaClientes(String filtroNome) {
        ClienteDAO clienteDAO = new ClienteDAO();
        java.util.List<Cliente> listaCompleta = clienteDAO.listarTodos(); 

        DefaultTableModel modelo = (DefaultTableModel) tbClientes.getModel();
        modelo.setNumRows(0); //limpa a tabela

        for (Cliente c : listaCompleta) {
            //filtro: verifica se o que o usuário digitou está no nome
            if (filtroNome == null || filtroNome.isEmpty() || 
                c.getNome().toLowerCase().contains(filtroNome.toLowerCase())) {

                modelo.addRow(new Object[]{
                    c.getId(),
                    c.getNome(),
                    c.getTelefone(),
                    c.getEndereco()
                });
            }
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPesquisaCliente = new javax.swing.JTextField();
        scrollClientes = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        scrollVeiculos = new javax.swing.JScrollPane();
        tbVeiculos = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 204));

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Telefone", "Endereço"
            }
        ));
        tbClientes.setFillsViewportHeight(true);
        scrollClientes.setViewportView(tbClientes);

        tbVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Placa", "Marca", "Modelo", "Ano", "Cor"
            }
        ));
        tbVeiculos.setFillsViewportHeight(true);
        scrollVeiculos.setViewportView(tbVeiculos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPesquisaCliente)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(txtPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollVeiculos, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(scrollClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollClientes;
    private javax.swing.JScrollPane scrollVeiculos;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTable tbVeiculos;
    private javax.swing.JTextField txtPesquisaCliente;
    // End of variables declaration//GEN-END:variables
}
