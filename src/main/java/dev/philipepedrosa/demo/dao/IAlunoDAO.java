package dev.philipepedrosa.demo.dao;

import dev.philipepedrosa.demo.model.Aluno;
import dev.philipepedrosa.demo.model.Cursos;

import java.util.List;
import java.util.Optional;

public interface IAlunoDAO {
    Optional<Aluno> create(Aluno aluno);
    void updateByID(Long id, Aluno aluno);
    void delete(Long matricula);
    List<Aluno> findAll();
    Optional<Aluno> findByID(Long matricula);
    List<Aluno> findByCurso(Cursos curso);
}
