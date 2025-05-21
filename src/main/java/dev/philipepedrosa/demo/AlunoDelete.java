package dev.philipepedrosa.demo;

import dev.philipepedrosa.demo.dao.AlunoDAO;
import dev.philipepedrosa.demo.dao.IAlunoDAO;

public class AlunoDelete {
    public static void main(String[] args) {
        // Testando delete
        IAlunoDAO alunoDAO = new AlunoDAO();
        long matriculaAlunoDeletar = alunoDAO.findAll().stream()
                .filter(aluno -> aluno.getNome().equals("Aluno Deletar"))
                .toList()
                .getFirst()
                .getMatricula();

        alunoDAO.delete(matriculaAlunoDeletar);
        System.out.println("Aluno deletado com sucesso!");
    }
}
