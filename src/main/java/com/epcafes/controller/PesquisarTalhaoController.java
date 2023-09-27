package com.epcafes.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epcafes.Service.TalhaoService;
import com.epcafes.model.Talhao;

@Controller
@RequestMapping("/talhoes")
public class PesquisarTalhaoController {
	
	private TalhaoService talhaoService;

    @GetMapping
    public List<Talhao> listarTalhoes() {
        return talhaoService.listarTalhoes();
    }
}
