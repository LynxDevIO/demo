package dev.philipepedrosa.demo.dao;

import java.util.List;
import java.util.Optional;

import dev.philipepedrosa.demo.model.Aluno;

public interface IAlunoDAO {
    Optional<Aluno> create(Aluno aluno);
    Aluno update(Aluno aluno);
    void updateByID(Long id, Aluno aluno);
    void delete(Long matricula);
    List<Aluno> findAll();
    Optional<Aluno> findByID(Long matricula);
    List<Aluno> findByCurso(String curso);
}
