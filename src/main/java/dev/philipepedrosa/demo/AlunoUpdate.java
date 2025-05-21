package dev.philipepedrosa.demo;

import dev.philipepedrosa.demo.dao.AlunoDAO;
import dev.philipepedrosa.demo.dao.IAlunoDAO;
import dev.philipepedrosa.demo.model.Aluno;

import java.util.Optional;

public class AlunoUpdate {
    public static void main(String[] args) {
        // Testando o update
        IAlunoDAO alunoDAO = new AlunoDAO();

        // Obtendo o aluno a ser atualizado
        Optional<Aluno> alunoOptional = alunoDAO.findByID(1L);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            aluno.setSexo("masculino");

            Aluno alunoAtualizado = alunoDAO.update(aluno);
            System.out.println("Matrícula: " + alunoAtualizado.getMatricula());
            System.out.println("Nome: " + alunoAtualizado.getNome());
            System.out.println("Sexo: " + alunoAtualizado.getSexo());
            System.out.println("Curso: " + alunoAtualizado.getCurso());
            System.out.println("Sexo: " + alunoAtualizado.getSexo());
        } else {
            System.out.println("Falha ao obter aluno por ID: retorno nulo, objeto vazio.");
        }
    }
}
