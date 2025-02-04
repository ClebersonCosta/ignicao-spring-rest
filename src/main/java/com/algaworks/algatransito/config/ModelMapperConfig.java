package com.algaworks.algatransito.config;

import com.algaworks.algatransito.api.model.output.VeiculoModel;
import com.algaworks.algatransito.domain.model.Veiculo;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        // mapeamento de propriedades, pois o atributo placa na classe VeiculoModel tem um nome diferente
        modelMapper.createTypeMap(Veiculo.class, VeiculoModel.class)
                .addMapping(Veiculo::getPlaca, VeiculoModel::setNumeroPlaca);

        return modelMapper;
    }

}