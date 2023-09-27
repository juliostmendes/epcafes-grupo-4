package com.epcafes.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.epcafes.model.Unidade;
import com.epcafes.repository.UnidadeRepository;

@Service
public class UnidadeService {
	@Autowired
    private UnidadeRepository unidadeRepository;

    @GetMapping
    public List<Unidade> listarUnidades() {
        return unidadeRepository.findAll();
    }

    @PostMapping
    public Unidade criarUnidade(@RequestBody Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

    @GetMapping("/{id}")
    public Unidade buscarUnidade(@PathVariable Long id) {
        return unidadeRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Unidade atualizarUnidade(@PathVariable Long id, @RequestBody Unidade novaUnidade) {
        return unidadeRepository.findById(id)
            .map(unidade -> {
                unidade.setNome(novaUnidade.getNome());
                unidade.setContato(novaUnidade.getContato());
                unidade.setTenant_id(novaUnidade.getTenant_id());
                return unidadeRepository.save(unidade);
            })
            .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarUnidade(@PathVariable Long id) {
        unidadeRepository.deleteById(id);
    }
}
