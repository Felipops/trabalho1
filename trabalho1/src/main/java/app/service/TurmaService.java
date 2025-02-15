package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Turma;
import app.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public String save(Turma turma) {
		this.turmaRepository.save(turma);
		return "Turma salvo com sucesso!";
	}
	
	public String delete(long id) {
		this.turmaRepository.deleteById(id);
		return "Turma deletado com sucesso!";
	}
	
	public Turma findById(long id) {
		return this.turmaRepository.findById(id).get();
	}
	
	public String update(long id,Turma turma) {
		turma.setId(id);
		this.turmaRepository.save(turma);
		return "Turma foi atualizado com sucesso!";
	}
	
	public List<Turma> findAll(){
		return this.turmaRepository.findAll();
	}
}
