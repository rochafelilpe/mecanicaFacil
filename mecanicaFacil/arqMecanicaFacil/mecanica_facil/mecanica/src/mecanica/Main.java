
package mecanica;
import java.util.ArrayList; 
import java.util.List;

public class Main {

    
    public static void main(String[] args) {
        System.out.println("-------- Protótipo de Cadastro de Listagem de Clientes e Veículos --------");
        
        //Criando as listas  
        List<Cliente> clientes = new ArrayList<>();
        List<Veiculo> veiculos = new ArrayList<>();
        
        //Protótipo de funcionalidades (Cadastro Cliente e Veiculo)
        System.out.println("Cadastrando um Cliente e um Veículo");
        
        //Novo cliente
        Cliente cliente1 = new Cliente (1, "Felipe Rocha", "(11) 95130-1888", "felipe.rocha@gmail.com");
        clientes.add(cliente1);
        
        //Novo  Veiculo, associado ao cliente1
        Veiculo veiculo1 = new Veiculo (1, "ABC-1234", "Fiat", "Uno", 2010, "Azul", cliente1);
        veiculos.add(veiculo1);
        
        System.out.println("   - Cliente 'Felipe Rocha' cadastrado com sucesso.");
        System.out.println("   - Veículo 'ABC-1234' cadastrado para 'Felipe Rocha'.");
        
        
        //Protótipo de funcionalidades (Listagem)
        System.out.println("Listando Clientes e seus Veículos...");
        
        for(Cliente c: clientes){
            //Exibe o nome e o email do cliente x
            System.out.println("\n -Cliente: " + c.getNome() + " (" + c.getEmail() + ")");
            
            boolean veiculoEncontrado = false;
            for(Veiculo v: veiculos){
                if(v.getCliente().getId() == c.getId()){
                    System.out.println("    - Veículo: Placa " + v.getPlaca() + ", " + v.getMarca() + " " + v.getModelo());
                    veiculoEncontrado = true; 
                }
            }
            if(!veiculoEncontrado){
                System.out.println("    - Nenhum veiculo encontrado para este cliente");
            }
        }
        
    }
    
}
