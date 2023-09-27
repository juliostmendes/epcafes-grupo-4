package com.epcafes.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.epcafes.model.Talhao;
import com.epcafes.repository.TalhaoRepository;

public class TalhaoService {
	@Autowired
    private TalhaoRepository talhaoRepository;

    @GetMapping
    public List<Talhao> listarTalhoes() {
        return talhaoRepository.findAll();
    }

    @PostMapping
    public Talhao criarTalhao(@RequestBody Talhao talhao) {
        return talhaoRepository.save(talhao);
    }

    @GetMapping("/{id}")
    public Optional<Talhao> buscarTalhao(@PathVariable Long id) {
        return talhaoRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Talhao atualizarTalhao(@PathVariable Long id, @RequestBody Talhao novoTalhao) {
        return talhaoRepository.findById(id)
            .map(talhao -> {
                talhao.setNome(novoTalhao.getNome());
                talhao.setArea(novoTalhao.getArea());
                talhao.setUnidade(novoTalhao.getUnidade());
                talhao.setTenant_id(novoTalhao.getTenant_id());
                return talhaoRepository.save(talhao);
            })
            .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarTalhao(@PathVariable Long id) {
        talhaoRepository.deleteById(id);
    }
}
