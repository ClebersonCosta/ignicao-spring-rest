package com.algaworks.algatransito.domain.service;

import com.algaworks.algatransito.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ApreensaoService {

    private final VeiculoService veiculoService;

    @Transactional
    public void apreender(Long veiculoId) {
        Veiculo v = veiculoService.buscar(veiculoId);
        v.apreender();
    }

    @Transactional
    public void removerApreensao(Long veiculoId) {
        Veiculo v = veiculoService.buscar(veiculoId);
        v.removerApreensao();
    }

}