package com.algaworks.algatransito.api.model.output;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class AutuacaoOutput {

    private Long id;
    private String descricao;
    private BigDecimal valorMulta;
    private OffsetDateTime dataOcorrencia;

}
