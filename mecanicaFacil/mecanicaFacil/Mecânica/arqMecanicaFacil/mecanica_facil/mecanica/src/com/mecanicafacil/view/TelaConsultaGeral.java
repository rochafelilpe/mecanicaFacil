package com.mecanicafacil.view;

import com.mecanicafacil.model.Cliente;
import com.mecanicafacil.model.Veiculo;
import com.mecanicafacil.repository.jdbc.ClienteDAO;
import com.mecanicafacil.repository.jdbc.VeiculoDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TelaConsultaGeral extends javax.swing.JPanel {

    
    public TelaConsultaGeral() {
        initComponents();
        preencherTabelaClientes(""); //carrega todos os clientes do banco quando a tela iniciar 
        preencherTabelaVeiculos(-1); //carrega todos os veiculos do banco quando a tela iniciar
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
    
    //metodo que usamos para povoar a tbVeiculos tanto na inicialização quanto para quando queremos saber os
    //carro de um cliente.
    private void preencherTabelaVeiculos(int idCliente){
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        List<Veiculo> lista;

        
        if (idCliente == -1) {
            //se for -1, puxa a frota inteira
            lista = veiculoDAO.listarTodos();
        } else {
            //se for um ID real, filtra pelo dono
            lista = veiculoDAO.buscarPorCliente(idCliente);
        }

        DefaultTableModel modelo = (DefaultTableModel) tbVeiculos.getModel();
        modelo.setNumRows(0);

        for (Veiculo v : lista) {
            modelo.addRow(new Object[]{
                v.getPlaca(),
                v.getMarca(),
                v.getModelo(),
                v.getAno(),
                v.getCor()
            });
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

        txtPesquisaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaClienteKeyReleased(evt);
            }
        });

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
        tbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClientesMouseClicked(evt);
            }
        });
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

    private void txtPesquisaClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaClienteKeyReleased
        String nomeBusca = txtPesquisaCliente.getText().trim();
    
        //chama o método de preenchimento
        preencherTabelaClientes(nomeBusca);
        DefaultTableModel modeloVeiculos = (DefaultTableModel) tbVeiculos.getModel();
        modeloVeiculos.setNumRows(0);
    }//GEN-LAST:event_txtPesquisaClienteKeyReleased

    private void tbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientesMouseClicked
        //armazena a linha selecionado pelo mouse
        int linha = tbClientes.getSelectedRow();
        if (linha != -1) {
            int id = (int) tbClientes.getValueAt(linha, 0);
            preencherTabelaVeiculos(id); //passa o ID real para FILTRAR
        }
    }//GEN-LAST:event_tbClientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollClientes;
    private javax.swing.JScrollPane scrollVeiculos;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTable tbVeiculos;
    private javax.swing.JTextField txtPesquisaCliente;
    // End of variables declaration//GEN-END:variables
}
