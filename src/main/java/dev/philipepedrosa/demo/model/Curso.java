package dev.philipepedrosa.demo.model;

public class Curso {
    private Long codigo;
    private String nome;
    private String sigla;
    private Area area;

    public Curso() {}

    public Curso(String sigla, String nome, Area area) {
        this.sigla = sigla;
        this.nome = nome;
        this.area = area;
    }

    public Curso(Long codigo, String sigla, String nome, Area area) {
        this.codigo = codigo;
        this.sigla = sigla;
        this.nome = nome;
        this.area = area;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
