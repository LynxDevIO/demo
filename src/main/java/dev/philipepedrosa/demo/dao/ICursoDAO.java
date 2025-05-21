package dev.philipepedrosa.demo.dao;

import java.util.List;
import java.util.Optional;

import dev.philipepedrosa.demo.model.Area;
import dev.philipepedrosa.demo.model.Curso;

public interface ICursoDAO {
    Optional<Curso> create(Curso curso);
    Curso update(Curso curso);
    void updateBySigla(String sigla, Curso curso);
    void delete(String sigla);
    List<Curso> findAll();
    Optional<Curso> findBySigla(String sigla);
    List<Curso> findByArea(Area area);
}
