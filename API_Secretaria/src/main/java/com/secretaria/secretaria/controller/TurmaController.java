package com.secretaria.secretaria.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.secretaria.secretaria.model.Turma;
import com.secretaria.secretaria.repository.TurmaRepository;

@RestController
@RequestMapping("/turma")
@CrossOrigin("*")
public class TurmaController {
	
	@Autowired
	private TurmaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Turma>> GetAll(){												//retorna minha tabela turma
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> GetById(@PathVariable long id){								//retorna o dado da tabela de acordo com id inserido na minha uri
		return repository.findById(id)															//retorna a resposta
				.map(resp -> ResponseEntity.ok(resp))											//retorna o notFound caso não exista ou exista erro na requisição
				.orElse(ResponseEntity.notFound().build());
	}
	
	/*@GetMapping("/turma/{turma}")
	public ResponseEntity<List<Turma>> GetByTurma (@PathVariable String turma){
		return ResponseEntity.ok(repository.findAllByTurmaContainingIgnoreCase(turma));			//	retorna os parametros inseridos pelo usuario do que contem no banco de dados deste atributo
	}*/
	
	@PostMapping
	public ResponseEntity<Turma> post (@RequestBody Turma turma){								//insere um novo dado
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(turma));
	}
	
	@PutMapping
	public ResponseEntity<Turma> put (@RequestBody Turma turma){								//atualiza um dado existente
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(turma));
	}
		
	@DeleteMapping("/{id}")																		//define o metodo a ser deletado
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
