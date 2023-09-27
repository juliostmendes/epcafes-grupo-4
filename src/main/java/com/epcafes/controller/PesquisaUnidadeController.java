package com.epcafes.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epcafes.Service.UnidadeService;
import com.epcafes.model.Unidade;

@Controller
@RequestMapping("/unidades")
public class PesquisaUnidadeController {
	
	private UnidadeService unidadeService;
	
	@GetMapping
    public List<Unidade> listarUnidades() {
        return unidadeService.listarUnidades();
    }
}
