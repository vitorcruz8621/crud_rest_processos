package com.example.demo.service;

import com.example.demo.model.Processo;
import com.example.demo.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessoService {

	@Autowired
    private final ProcessoRepository processoRepository;

    public ProcessoService(ProcessoRepository processoRepository) {
        this.processoRepository = processoRepository;
    }

    public List<Processo> getAllProcessos() {
        return processoRepository.findAll();
    }

    public Optional<Processo> getProcessoById(Long id) {
        return processoRepository.findById(id);
    }
    
    public List<Processo> getProcessoByUf(String uf) {
        return processoRepository.findByUf(uf);
    }
    
    public List<Processo> getProcessoByUfAndMunicipio(String uf, String municipio) {
        return processoRepository.findByUfAndMunicipio(uf, municipio);
    }

    @Transactional
    public Processo createProcesso(Processo processo) {
        return processoRepository.save(processo);
    }

    @Transactional
    public Processo updateProcesso(Long id, Processo processo) {
        processo.setId(id);
        return processoRepository.save(processo);
    }

    public void deleteProcesso(Long id) {
        processoRepository.deleteById(id);
    }
}
