package com.algaworks.algatransito.api.assembler;

import com.algaworks.algatransito.api.model.output.VeiculoOutput;
import com.algaworks.algatransito.api.model.input.VeiculoInput;
import com.algaworks.algatransito.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class VeiculoAssembler {

    private final ModelMapper mapper;

    public VeiculoOutput toModel(Veiculo veiculo) {
        return mapper.map(veiculo, VeiculoOutput.class);
    }

    public List<VeiculoOutput> toCollectionModel(List<Veiculo> veiculos) {
        return veiculos.stream().map(this::toModel).toList();
    }

    public Veiculo toEntity(VeiculoInput veiculoInput) {
        return mapper.map(veiculoInput, Veiculo.class);
    }
}
