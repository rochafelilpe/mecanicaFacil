    
package com.mecanicafacil.repository;


import com.mecanicafacil.model.Servico;
import java.util.List;

public interface ServicoRepository {
    void registrar(Servico servico);
    
    List<Servico> listarTodos(); 
    
    List<Servico> buscarPorPlaca(String placa);
        
}
