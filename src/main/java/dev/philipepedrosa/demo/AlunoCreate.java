package dev.philipepedrosa.demo;

import dev.philipepedrosa.demo.dao.AlunoDAO;
import dev.philipepedrosa.demo.dao.IAlunoDAO;
import dev.philipepedrosa.demo.model.Aluno;

public class AlunoCreate {
    public static void main(String[] args) {
        // testando
        IAlunoDAO alunoDAO = new AlunoDAO();

        Aluno aluno = new Aluno();
        aluno.setNome("Batman Brasileiro");
        aluno.setMaioridade(true);
        aluno.setCurso("ECMP");
        aluno.setSexo("feminino");

        Aluno novoAluno = alunoDAO.create(aluno).orElse(null);
        if (novoAluno != null) {
            System.out.println("Matrícula do novo aluno: " + novoAluno.getMatricula());
        } else {
            System.out.println("Falha no cadastro do aluno.");
        }

        Aluno alunoDeletar = new Aluno();
        aluno.setNome("Aluno Deletar");
        aluno.setMaioridade(false);
        aluno.setCurso("OUTROS");
        aluno.setSexo("Helicóptero de Combate");

        Aluno novoAluno2 = alunoDAO.create(aluno).orElse(null);

        if (novoAluno2 == null) {
            System.out.println("Falha no cadastro do aluno para deletar.");
        }
    }
}
