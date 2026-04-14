
package com.mecanicafacil.teste;

import com.mecanicafacil.model.Cliente;
import com.mecanicafacil.model.Veiculo;
import com.mecanicafacil.repository.jdbc.ClienteDAO;
import com.mecanicafacil.repository.jdbc.VeiculoDAO;

public class testeVeiculo {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        VeiculoDAO veiculoDAO = new VeiculoDAO();

        try{
            //criando um cliente no banco primeiro
            Cliente dono = new Cliente();
            dono.setNome("Felipe Rocha");
            dono.setTelefone("11999998888");
            dono.setEndereco("Rua da Oficina, 10");
            
            
            // Utilizando o id 3, por que por testes passados, excluí os demais.
            dono.setId(3); 

            //criando o Veículo (RF2 - Cadastro)
            Veiculo novoVeiculo = new Veiculo();
            novoVeiculo.setPlaca("ABC1D23");
            novoVeiculo.setMarca("Volkswagen");
            novoVeiculo.setModelo("Golf");
            novoVeiculo.setAno(2024);
            novoVeiculo.setCor("Preto");
            novoVeiculo.setCliente(dono); // Associando ao cliente

            System.out.println("Tentando registrar veículo...");
            veiculoDAO.registrar(novoVeiculo);

            //testando a Atualização (RF2 - Edição)
            // O cliente que criamos agora foi o primeiro a ser criado (id=1)
            novoVeiculo.setId(1); 
            novoVeiculo.setCor("Azul Metálico");
            System.out.println("Tentando atualizar cor do veículo...");
            veiculoDAO.atualizar(novoVeiculo);

            // testando a Exclusão (RF2 - Exclusão)
            // Descomente a linha abaixo para testar o delete
            // veiculoDAO.excluir(1);

        } catch (Exception e) {
            System.err.println("ERRO NO TESTE DE VEÍCULO: " + e.getMessage());
        }
    }
}
