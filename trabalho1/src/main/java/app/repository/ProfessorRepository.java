package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	
	public Professor findByEmail(String email);

	public List<Professor> findByNomeStartingWith(String nome);

	public List<Professor> findByEmailNotLike(String email);
}
