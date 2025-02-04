package com.algaworks.algatransito.domain.service;

import com.algaworks.algatransito.domain.model.Autuacao;
import com.algaworks.algatransito.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class AutuacaoService {

    private final VeiculoService service;

    @Transactional
    public Autuacao salvar(Long veiculoId, Autuacao autuacao) {
        Veiculo v = service.buscar(veiculoId);
        return v.adicionarAutuacao(autuacao);
    }
}