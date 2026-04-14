
package com.mecanicafacil.repository;

import com.mecanicafacil.model.Veiculo;
import java.util.List;


public interface VeiculoRepository {
    void registrar(Veiculo veiculo);
    void atualizar(Veiculo veiculo);
    void excluir(int id);
}
