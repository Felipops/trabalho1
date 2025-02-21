package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Professor;
import app.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public String save(Professor professor) {
		
		Professor emailExistente = this.professorRepository.findByEmail(professor.getEmail());
		if(emailExistente != null) {
			throw new RuntimeException("Jà existe o professor com esse email");		
		}
		if (professor.getEmail()!= null && professor.getEmail().contains("@outlook.com")){
			throw new RuntimeException("Dominio de e-mail nao permitido");		
		}
		
		this.professorRepository.save(professor);
		return "Professor salvo com sucesso!";
	}
	
	public String delete(long id) {
		this.professorRepository.deleteById(id);
		return "Professor deletado com sucesso!";
	}
	
	public Professor findById(long id) {
		return this.professorRepository.findById(id).get();
	}
	
	public String update(long id,Professor professor) {
		professor.setId(id);
		this.professorRepository.save(professor);
		return "Professor foi atualizado com sucesso!";
	}
	
	public List<Professor> findAll(){
		return this.professorRepository.findAll();
	}
}
