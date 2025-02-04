package com.algaworks.algatransito.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class AutuacaoInput {

    @NotBlank
    private String descricao;

    @NotBlank
    @Positive
    private BigDecimal valorMulta;

}
