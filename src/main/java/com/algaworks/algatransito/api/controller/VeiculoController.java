package com.algaworks.algatransito.api.controller;

import com.algaworks.algatransito.api.assembler.VeiculoAssembler;
import com.algaworks.algatransito.api.model.output.VeiculoOutput;
import com.algaworks.algatransito.api.model.input.VeiculoInput;
import com.algaworks.algatransito.domain.model.Veiculo;
import com.algaworks.algatransito.domain.repository.VeiculoRepository;
import com.algaworks.algatransito.domain.service.VeiculoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService service;
    private final VeiculoRepository repository;
    private final VeiculoAssembler veiculoAssembler;

    @GetMapping
    public List<VeiculoOutput> listarTodos() {
        return veiculoAssembler.toCollectionModel(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoOutput> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(veiculoAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoOutput adicionar(@Valid @RequestBody VeiculoInput veiculoInput) {
        Veiculo veiculo = veiculoAssembler.toEntity(veiculoInput);
        return veiculoAssembler.toModel(service.salvar(veiculo));
    }

}