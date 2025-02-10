package com.algaworks.algatransito.api.assembler;

import com.algaworks.algatransito.api.model.input.AutuacaoInput;
import com.algaworks.algatransito.api.model.output.AutuacaoOutput;
import com.algaworks.algatransito.domain.model.Autuacao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class AutuacaoAssembler {

    private final ModelMapper mapper;

    public AutuacaoOutput toModel(Autuacao autuacao) {
        return mapper.map(autuacao, AutuacaoOutput.class);
    }

    public List<AutuacaoOutput> toCollectionModel(List<Autuacao> autuacoes) {
        return autuacoes.stream()
                .map(this::toModel)
                .toList();
    }

    public Autuacao toEntity(AutuacaoInput autuacaoInput) {
        return mapper.map(autuacaoInput, Autuacao.class);
    }

}