package com.algaworks.algatransito.domain.service;

import com.algaworks.algatransito.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algatransito.domain.exception.NegocioException;
import com.algaworks.algatransito.domain.model.Proprietario;
import com.algaworks.algatransito.domain.model.StatusVeiculo;
import com.algaworks.algatransito.domain.model.Veiculo;
import com.algaworks.algatransito.domain.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class VeiculoService {

    private final VeiculoRepository repository;
    private final ProprietarioService service;

    @Transactional
    public Veiculo salvar(Veiculo veiculo) {
        if (veiculo.getId() != null) {
            throw new NegocioException("Veiculo não pode ter id");
        }

        boolean placaDuplicada = repository.findByPlaca(veiculo.getPlaca())
                        .filter(v -> !v.equals(veiculo))
                        .isPresent();

        if (placaDuplicada) {
            throw new NegocioException("Placa duplicada");
        }

        Proprietario p = service.buscar(veiculo.getProprietario().getId());
        veiculo.setProprietario(p);

        veiculo.setStatus(StatusVeiculo.REGULAR);
        veiculo.setDataCadastro(OffsetDateTime.now());

        return repository.save(veiculo);
    }

    public Veiculo buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Veiculo não encontrado"));
    }

}
