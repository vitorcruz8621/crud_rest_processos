package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "tabela_processos")
public class Processo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private String npu;

    @Column(name = "data_cadastro", nullable = false)
    @Getter
    @Setter
    private LocalDate dataCadastro;

    @Column(name = "data_visualizacao")
    @Getter
    @Setter
    private LocalDate dataVisualizacao;

    @Column(nullable = false)
    @Getter
    @Setter
    private String municipio;

    @Column(nullable = false)
    @Getter
    @Setter
    private String uf;
/*
    @Lob
    @Column(name = "documento_pdf", nullable = false)
    @Getter
    @Setter
    private byte[] documentoPdf;*/
}
