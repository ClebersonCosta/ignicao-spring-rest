package com.algaworks.algatransito.api.controller;

import com.algaworks.algatransito.domain.model.Proprietario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProprietarioController {

    @GetMapping("/proprietarios")
    public List<Proprietario> listar() {
        var p1 = new Proprietario();
        p1.setId(1L);
        p1.setNome("João");
        p1.setTelefone("11 99999-8888");
        p1.setEmail("joao@algaworks.com.br");

        var p2 = new Proprietario();
        p2.setId(2L);
        p2.setNome("Maria");
        p2.setTelefone("11 99999-7777");
        p2.setEmail("maria@algaworks.com.br");

        return Arrays.asList(p1,p2);
    }
}
