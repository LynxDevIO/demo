package dev.philipepedrosa.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.philipepedrosa.demo.config.ConnectionFactory;
import dev.philipepedrosa.demo.model.Area;
import dev.philipepedrosa.demo.model.Curso;

public class CursoDAO implements ICursoDAO {
    /*
     CREATE TABLE cursos (
        codigo BIGSERIAL PRIMARY KEY,
        nome VARCHAR(150) NOT NULL,
        sigla VARCHAR(20) UNIQUE NOT NULL,
        area VARCHAR(100) NOT NULL
    );

     */
    
    @Override
    public Optional<Curso> create(Curso curso) {
        String sql = "insert into cursos (sigla, nome, area) values (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, curso.getSigla());
            ps.setString(2, curso.getNome());
            ps.setString(3, curso.getArea().toString());
            ps.executeUpdate();
            ps.close();
            System.out.println("BANCO DE DADOS: Curso " + curso.getSigla() + " criado com sucesso!");
            return Optional.of(curso);
        } catch (SQLException e) {
            System.err.println("Erro ao inserir curso: " + e.getMessage());
        }
        return Optional.empty();
    }
    
    @Override
    public Curso update(Curso curso) {
        String sql = "update cursos set nome = ?, area = ? where sigla = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, curso.getNome());
            ps.setString(2, curso.getArea().toString());
            ps.setString(3, curso.getSigla());
            ps.executeUpdate();
            ps.close();
            System.out.println("BANCO DE DADOS: Curso " + curso.getNome() + " atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar curso: " + e.getMessage());
        }
        return curso;
    }

    @Override
    public void updateBySigla(String sigla, Curso curso) {
        String sql = "update cursos set nome = ?, area = ? where sigla = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, curso.getNome());
            ps.setString(2, curso.getArea().toString());
            ps.setString(3, sigla);
            ps.executeUpdate();
            ps.close();
            System.out.println("BANCO DE DADOS: Curso " + sigla + " atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar curso: " + e.getMessage());
        }
    }

    @Override
    public void delete(String sigla) {
        String sql = "delete from cursos where sigla = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sigla);
            ps.execute();
            ps.close();
            System.out.println("BANCO DE DADOS: Curso " + sigla + " deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar curso: " + e.getMessage());
        }
    }

    @Override
    public List<Curso> findAll() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "select * from cursos";
        try (Connection conn = ConnectionFactory.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setSigla(rs.getString("sigla"));
                curso.setNome(rs.getString("nome"));
                curso.setArea(Area.valueOf(rs.getString("area")));
                cursos.add(curso);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar cursos: " + e.getMessage());
        }
        return cursos;
    }

    @Override
    public Optional<Curso> findBySigla(String sigla) {
        String sql = "select * from cursos where sigla = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sigla);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Curso curso = new Curso();
                curso.setSigla(rs.getString("sigla"));
                curso.setNome(rs.getString("nome"));
                curso.setArea(Area.valueOf(rs.getString("area")));
                return Optional.of(curso);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar curso: " + e.getMessage());
        }
        return Optional.empty();
    }
    
    @Override
    public List<Curso> findByArea(Area area) {
        List<Curso> cursos = new ArrayList<>();
        String sql = "select * from cursos where area = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, area.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setSigla(rs.getString("sigla"));
                curso.setNome(rs.getString("nome"));
                curso.setArea(Area.valueOf(rs.getString("area")));
                cursos.add(curso);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar cursos por área: " + e.getMessage());
        }
        return cursos;
    }
}
