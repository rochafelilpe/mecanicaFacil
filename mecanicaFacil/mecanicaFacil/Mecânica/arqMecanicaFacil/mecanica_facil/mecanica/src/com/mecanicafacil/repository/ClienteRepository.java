
package com.mecanicafacil.repository;


import com.mecanicafacil.model.Cliente;
import java.util.List;

public interface ClienteRepository {
    void salvar(Cliente cliente); 
     
    List<Cliente> listarTodos(); 
    
    void atualizar(Cliente cliente);
    
    void excluir(int id); 
    
    
}
