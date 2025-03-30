package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Turma;
import app.service.TurmaService;

@RestController
@RequestMapping("/api/turma")
@CrossOrigin("*")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Turma turma){
		try {
			String mensagem = this.turmaService.save(turma);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Deu erro!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			String mensagem = this.turmaService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Deu erro!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Turma> findById(@PathVariable long id){
		try {
			Turma turma = this.turmaService.findById(id);
			return new ResponseEntity<>(turma, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable long id, @RequestBody Turma turma){
		try {
			String mensagem = this.turmaService.update(id, turma);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Turma>> findAll(){
		try {
			List<Turma> lista = this.turmaService.findAll();
			return new ResponseEntity<>(lista,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
//	@GetMapping("/findByAnoBetween")
//	public ResponseEntity<List<Turma>> findByAnoBetween(@RequestParam int ano1,
//			@RequestParam int ano2){
//		try {
//			return new ResponseEntity<>(this.turmaService.findByAnoBetween(ano1,ano2), HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
//
//		}
//	}
	
	
	@GetMapping("/findBySemestreAndAno")
	public ResponseEntity<List<Turma>> findBySemestreAndAno(@RequestParam String semestre, @RequestParam int ano) {
	    try {
	        List<Turma> turmas = this.turmaService.findBySemestreAndAno(semestre, ano);
	        return new ResponseEntity<>(turmas, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    }
	}

	
	@GetMapping("/findByNomeAndTurno")
	public ResponseEntity<List<Turma>> findByNomeAndTurno(@RequestParam String nome, @RequestParam String turno) {
	    try {
	        List<Turma> turmas = this.turmaService.findByNomeAndTurno(nome, turno);
	        return new ResponseEntity<>(turmas, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    }
	}

	@GetMapping("/findByCurso")
	public ResponseEntity<List<Turma>> findByCurso(@RequestParam String nomeCurso) {
	    try {
	        List<Turma> turmas = this.turmaService.findByCursoNome(nomeCurso);
	        return new ResponseEntity<>(turmas, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    }
	}
	
	
}
