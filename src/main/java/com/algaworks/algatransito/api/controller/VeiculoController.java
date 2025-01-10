package com.algaworks.algatransito.api.controller;

import com.algaworks.algatransito.api.model.VeiculoModel;
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

    @GetMapping
    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoModel> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(veiculo -> {
                    var vm = new VeiculoModel();
                    vm.setId(veiculo.getId());
                    vm.setNomeProprietario(veiculo.getProprietario().getNome());
                    vm.setMarca(veiculo.getMarca());
                    vm.setModelo(veiculo.getModelo());
                    vm.setPlaca(veiculo.getPlaca());
                    vm.setStatus(veiculo.getStatus());
                    vm.setDataCadastro(veiculo.getDataCadastro());
//                    vm.setDataApreensao(veiculo.getDataApreensao());
                    return vm;
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo adicionar(@Valid @RequestBody Veiculo veiculo) {
        return service.salvar(veiculo);
    }

}