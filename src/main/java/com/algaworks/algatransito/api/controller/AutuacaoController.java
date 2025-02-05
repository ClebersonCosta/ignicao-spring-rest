package com.algaworks.algatransito.api.controller;

import com.algaworks.algatransito.api.assembler.AutuacaoAssembler;
import com.algaworks.algatransito.api.model.input.AutuacaoInput;
import com.algaworks.algatransito.api.model.output.AutuacaoOutput;
import com.algaworks.algatransito.domain.model.Autuacao;
import com.algaworks.algatransito.domain.service.AutuacaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos/{veiculoId}/autuacoes")
public class AutuacaoController {

    private final AutuacaoService service;
    private final AutuacaoAssembler assembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutuacaoOutput adicionar(@PathVariable Long veiculoId, @Valid @RequestBody AutuacaoInput autuacaoInput) {
        Autuacao autuacao = assembler.toEntity(autuacaoInput);
        return assembler.toModel(service.salvar(veiculoId, autuacao));
    }

}