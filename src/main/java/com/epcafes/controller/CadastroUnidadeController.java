package com.epcafes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epcafes.Service.UnidadeService;
import com.epcafes.model.Unidade;

@Controller
@RequestMapping("/unidades")
public class CadastroUnidadeController {

    private UnidadeService unidadeService;
    
    @PostMapping
    public Unidade criarUnidade(@RequestBody Unidade unidade) {
        return unidadeService.criarUnidade(unidade);
    }

    @GetMapping("/{id}")
    public Unidade buscarUnidade(@PathVariable Long id) {
        return unidadeService.buscarUnidade(id);
    }

    @PutMapping("/{id}")
    public Unidade atualizarUnidade(@PathVariable Long id, @RequestBody Unidade novaUnidade) {
        return unidadeService.atualizarUnidade(id, novaUnidade);
    }

    @DeleteMapping("/{id}")
    public void deletarUnidade(@PathVariable Long id) {
        unidadeService.deletarUnidade(id);
    }
}