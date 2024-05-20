package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Processo;
import com.example.demo.service.ProcessoService;

@RestController
@RequestMapping("/processos")
public class ProcessoController {

	private final ProcessoService processoService;

    ProcessoController(ProcessoService processoService) {
        this.processoService = processoService;
    }

    @GetMapping
    public ResponseEntity<List<Processo>> getAllProcessos() {
        List<Processo> processos = processoService.getAllProcessos();
        return ResponseEntity.ok(processos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Processo> getProcessoById(@PathVariable Long id) {
        return processoService.getProcessoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Processo> createProcesso(@RequestBody Processo processo) {
        Processo createdProcesso = processoService.createProcesso(processo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProcesso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Processo> updateProcesso(@PathVariable Long id, @RequestBody Processo processo) {
        return processoService.getProcessoById(id)
                .map(existingProcesso -> {
                    Processo updatedProcesso = processoService.updateProcesso(id, processo);
                    return ResponseEntity.ok(updatedProcesso);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcesso(@PathVariable Long id) {
        processoService.deleteProcesso(id);
        return ResponseEntity.noContent().build();
    }
}
