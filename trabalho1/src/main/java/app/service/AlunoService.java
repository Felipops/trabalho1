package app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Aluno;
import app.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public String save(Aluno aluno) {
		
			Aluno alunoExistente = this.alunoRepository.findByCpf(aluno.getCpf());
			if(alunoExistente != null) {
				throw new RuntimeException("Jà existe o aluno COM O CPF ");			
	 }
			validarCadastroCompleto(aluno);	
		this.alunoRepository.save(aluno);
		return "Aluno salvo com sucesso!";
	}
	
	public String delete(long id) {
		this.alunoRepository.deleteById(id);
		return "Aluno deletado com sucesso!";
	}
	
	public Aluno findById(long id) {
		return this.alunoRepository.findById(id).get();
	}
	
	public String update(long id, Aluno aluno) {
		aluno.setId(id);
		
		validarCadastroCompleto(aluno);
		this.alunoRepository.save(aluno);
		return "Aluno foi atualizado com sucesso!";
	}
	
	public List<Aluno> findAll(){
		return this.alunoRepository.findAll();
	}
	
	public List <Aluno> findByNome (String nome){
		return this.alunoRepository.findByNomeStartingWith(nome);
		}
	
	public List<Aluno> buscarTelefone(String telefone) {
        return this.alunoRepository.findByTelefoneContaining(telefone);
    }
	
	public List<Aluno> buscarNomeDaTurma(String nomeTurma) {
        return this.alunoRepository.findByTurmaNome(nomeTurma);
    }
	private void validarCadastroCompleto(Aluno aluno) {
		if (aluno.getTelefone()==null||aluno.getTelefone().isEmpty()) {
			aluno.setCadastroCompleto(false);
		}else {
			aluno.setCadastroCompleto(true);
		}
		
	}
	
}
