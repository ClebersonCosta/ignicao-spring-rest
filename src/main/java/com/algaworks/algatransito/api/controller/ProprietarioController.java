package com.algaworks.algatransito.api.controller;

import com.algaworks.algatransito.domain.model.Proprietario;
import com.algaworks.algatransito.domain.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ProprietarioController {

    private final ProprietarioRepository repository;

    @GetMapping("/proprietarios")
    public List<Proprietario> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/proprietarios/{nome}")
    public List<Proprietario> listarPorNome(@PathVariable(value = "nome") String nome) {
        return repository.findByNomeContaining(nome);
    }
}
