package com.algaworks.algatransito.domain.service;

import com.algaworks.algatransito.domain.model.Proprietario;
import com.algaworks.algatransito.domain.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ProprietarioService {

    public final ProprietarioRepository repository;

    @Transactional
    public Proprietario salvar(Proprietario p) {
        return repository.save(p);
    }

    @Transactional
    public void excluir(Long id) {
        repository.deleteById(id);
    }

}