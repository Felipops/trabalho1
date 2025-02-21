package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	public List<Aluno> findByNomeStartingWith(String nome);
	
	public List<Aluno> findByTelefoneContaining(String telefone);

	public List <Aluno>findByTurmaNome(String nomeTurma);
}
