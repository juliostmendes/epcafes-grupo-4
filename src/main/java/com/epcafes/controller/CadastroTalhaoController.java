package com.epcafes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epcafes.Service.TalhaoService;
import com.epcafes.model.Talhao;

@Controller
@RequestMapping("/talhoes")
public class CadastroTalhaoController {
    
	@Autowired
	private TalhaoService talhaoService;

    @PostMapping("/criar")
    public String criarTalhao(Talhao talhao) {
    	talhaoService.criarTalhao(talhao);
        return "talhao/talhao";
    }

    @GetMapping("/{id}")
    public String buscarTalhao(@PathVariable Long id, Model model) {
    	Optional<Talhao> talhao = talhaoService.buscarTalhao(id);
    	model.addAttribute("morador", talhao);
        return "talhao/talhao";
    }

    @PutMapping("/{id}")
    public Talhao atualizarTalhao(@PathVariable Long id, @RequestBody Talhao novoTalhao) {
        return talhaoService.atualizarTalhao(id, novoTalhao);
    }

    @GetMapping("/{id}")
    public void deletarTalhao(@PathVariable(value = "id") Long id) {
    	Optional<Talhao> talhaoOptional = talhaoService.buscarTalhao(id);
        talhaoService.deletarTalhao(id);
    }
    
//    @GetMapping("/deletar/{id}")
//	public String deletarMorador(@PathVariable(value = "id") Long id) {
//		Optional<Morador> moradorOptional = moradorService.findById(id);
//		if(!moradorOptional.isPresent()) {
//			
//		}
//		moradorService.delete(moradorOptional.get());
//		return "redirect:/morador";
//	}
}