package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Professor;
import app.service.ProfessorService;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Professor professor){
		try {
			String mensagem = this.professorService.save(professor);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Deu erro!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			String mensagem = this.professorService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Deu erro!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Professor> findById(@PathVariable long id){
		try {
			Professor professor = this.professorService.findById(id);
			return new ResponseEntity<>(professor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable long id, @RequestBody Professor professor){
		try {
			String mensagem = this.professorService.update(id, professor);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Professor>> findAll(){
		try {
			List<Professor> lista = this.professorService.findAll();
			return new ResponseEntity<>(lista,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/buscarNomeProfessor")
    public ResponseEntity<List<Professor>> buscarPorNomeProfessor(@RequestParam String nome) {
        try {
            List<Professor> professores = this.professorService.findByNome(nome);
            return new ResponseEntity<>(professores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
	
	@GetMapping("/buscarSemGmail")
    public ResponseEntity<List<Professor>> buscarProfessoresSemGmail() {
        try {
            List<Professor> professores = professorService.buscarProfessoresSemGmail();
            return new ResponseEntity<>(professores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
	
	
		@GetMapping("/findByEmail")
		public ResponseEntity<Professor> findByEmail(@RequestParam String email) {
		    try {
		        Professor professor = this.professorService.findByEmail(email);
		        return new ResponseEntity<>(professor, HttpStatus.OK);
		    } catch (RuntimeException e) {
		        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // Retorna 404 caso não encontre
		    }
		} 
}
 
