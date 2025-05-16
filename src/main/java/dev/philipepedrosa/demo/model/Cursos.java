package dev.philipepedrosa.demo.model;

import java.io.Serializable;

public enum Cursos implements Serializable {
    ADS("Análise e Desenvolvimento de Sistemas"),
    ECMP("Engenharia da Computação"),
    CCMP("Ciência da Computação"),
    OUTROS("Outros");

    private String nomeCurso;

    private Cursos(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeCurso() {
        return this.nomeCurso;
    }
}
