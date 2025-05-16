// AULA 15/05/2025

package dev.philipepedrosa.demo;

import dev.philipepedrosa.demo.dao.AlunoDAO;
import dev.philipepedrosa.demo.dao.IAlunoDAO;
import dev.philipepedrosa.demo.model.Aluno;
import dev.philipepedrosa.demo.model.Cursos;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // todo: interface näo implementada; código executa no console.
        //MainView view = new MainView();
        //view.initialize();

        IAlunoDAO alunoDAO = new AlunoDAO();

        Aluno aluno1 = new Aluno(1L, "Amanda Nunes", true, Cursos.ADS, "Feminino");
        Aluno aluno2 = new Aluno(2L, "Bernardo Rocha", false, Cursos.ECMP, "Masculino");
        Aluno aluno3 = new Aluno(3L, "Clara Faria", true, Cursos.CCMP, "Feminino");
        Aluno aluno4 = new Aluno(4L, "Diego Martins", true, Cursos.ADS, "Masculino");
        Aluno aluno5 = new Aluno(5L, "Elisa Andrade", false, Cursos.OUTROS, "Feminino");
        Aluno aluno6 = new Aluno(6L, "Felipe Barros", true, Cursos.ECMP, "Masculino");
        Aluno aluno7 = new Aluno(7L, "Gabriela Costa", true, Cursos.CCMP, "Feminino");
        Aluno aluno8 = new Aluno(8L, "Hugo Dias", false, Cursos.ADS, "Masculino");
        Aluno aluno9 = new Aluno(9L, "Isabela Gomes", true, Cursos.OUTROS, "Feminino");
        Aluno aluno10 = new Aluno(10L, "João Lima", true, Cursos.ECMP, "Masculino");

        alunoDAO.create(aluno1);
        alunoDAO.create(aluno2);
        alunoDAO.create(aluno3);
        alunoDAO.create(aluno4);
        alunoDAO.create(aluno5);
        alunoDAO.create(aluno6);
        alunoDAO.create(aluno7);
        alunoDAO.create(aluno8);
        alunoDAO.create(aluno9);
        alunoDAO.create(aluno10);

        alunoDAO.delete(3L);
        alunoDAO.findByCurso(Cursos.ADS);

        System.out.println("\n///////");
        var alunoX = new Aluno(1L, "Philipe Pedrosa", true, Cursos.ADS, "Masculino");
        alunoDAO.updateByID(1L, alunoX);

        var lista = alunoDAO.findAll();
        for (Aluno a : lista) {
            System.out.println("Matrícula " + a.getMatricula());
            System.out.println("Nome: " + a.getNome());
            System.out.println(a.isMaioridade()? " - Adulto " : " - Adolescente");
            System.out.println("Curso: " + a.getCurso().getNomeCurso());
            System.out.println("Sexo: " + a.getSexo());
            System.out.println("=================================================");
        }

        System.out.println("\n#Pesquisa por matrícula 100: ");
        Optional<Aluno> aluno = alunoDAO.findByID(12L);
        aluno.ifPresent(a -> {
            System.out.println("Matrícula " + a.getMatricula());
            System.out.println("Nome: " + a.getNome());
            System.out.println(a.isMaioridade()? " - Adulto " : " - Adolescente");
            System.out.println("Curso: " + a.getCurso().getNomeCurso());
            System.out.println("Sexo: " + a.getSexo());
        });
    }
}
