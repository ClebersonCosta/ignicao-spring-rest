package com.algaworks.algatransito.domain.service;

import com.algaworks.algatransito.domain.exception.ProprietarioException;
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
    public Proprietario salvar(Proprietario proprietario) {
        boolean emailCadastrado = repository.findByEmail(proprietario.getEmail())
                .filter(p -> !p.equals(proprietario))
                .isPresent();

        if (emailCadastrado) {
            throw new ProprietarioException("Email já cadastrado");
        }
        return repository.save(proprietario);
    }

    @Transactional
    public void excluir(Long id) {
        repository.deleteById(id);
    }

}