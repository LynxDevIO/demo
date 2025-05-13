package dev.philipepedrosa.demo.dao;

import dev.philipepedrosa.demo.config.ConnectionFactory;
import dev.philipepedrosa.demo.model.Aluno;
import dev.philipepedrosa.demo.model.Cursos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlunoDAO implements IAlunoDAO {
    /*
    create table alunos(" +
                "matricula int generated always as identity primary key, " +
                "nome varchar(150) not null, " +
                "maioridade boolean, " +
                "curso varchar(150), " +
                "sexo varchar(50))
     */

    @Override
    public void create(Aluno aluno) {
        String sql = "insert into alunos (nome, maioridade, curso, sexo) values(?,?,?,?)";
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setBoolean(2, aluno.isMaioridade());
            ps.setString(3, aluno.getCurso().toString());
            ps.setString(4, aluno.getSexo());
            ps.executeUpdate();
            ps.close();

            System.out.println("BANCO DE DADOS: Aluno " + aluno.getNome() + " criado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateByID(Long matricula, Aluno aluno) {
        String sql = "update alunos set nome = ?, maioridade = ?, curso = ?, sexo = ? where matricula = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setBoolean(2, aluno.isMaioridade());
            ps.setString(3, aluno.getCurso().toString());
            ps.setString(4, aluno.getSexo());
            ps.setLong(5, matricula);
            ps.executeUpdate();
            ps.close();

            System.out.println("BANCO DE DADOS: Aluno " + aluno.getNome() + " alterado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long matricula) {
        String sql = "delete from alunos where matricula = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, matricula);
            ps.execute();
            ps.close();

            System.out.println("BANCO DE DADOS: Aluno " + matricula + " deletado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> findAll() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "select * from alunos";
        try (Connection conn = ConnectionFactory.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setMatricula(rs.getLong("matricula"));
                aluno.setNome(rs.getString("nome"));
                aluno.setMaioridade(rs.getBoolean("maioridade"));
                aluno.setCurso(Cursos.valueOf(rs.getString("curso")));
                aluno.setSexo(rs.getString("sexo"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar alunos: " + e.getMessage());
        }
        System.out.println("BANCO DE DADOS: Alunos encontrados com sucesso!");
        return alunos;
    }

    @Override
    public Optional<Aluno> findByID(Long matricula) {
        Optional<Aluno> aluno = Optional.empty();
        String sql = "select * from alunos where matricula = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, matricula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                aluno = Optional.of(new Aluno());
                aluno.get().setMatricula(rs.getLong("matricula"));
                aluno.get().setNome(rs.getString("nome"));
                aluno.get().setMaioridade(rs.getBoolean("maioridade"));
                aluno.get().setCurso(Cursos.valueOf(rs.getString("curso")));
                aluno.get().setSexo(rs.getString("sexo"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar aluno: " + e.getMessage());
        }
        System.out.println("BANCO DE DADOS: aluno " + matricula + " encontrado com sucesso!");
        return aluno;
    }

    @Override
    public List<Aluno> findByCurso(Cursos curso) {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "select * from alunos where curso = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, curso.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setMatricula(rs.getLong("matricula"));
                aluno.setNome(rs.getString("nome"));
                aluno.setMaioridade(rs.getBoolean("maioridade"));
                aluno.setCurso(Cursos.valueOf(rs.getString("curso")));
                aluno.setSexo(rs.getString("sexo"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar alunos por curso: " + e.getMessage());
        }
        System.out.println("BANCO DE DADOS: alunos do curso " + curso.toString() + " encontrados com sucesso!");
        return alunos;
    }
}
