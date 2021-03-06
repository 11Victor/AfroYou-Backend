package br.com.afroyou.controller;

import java.util.List;

import javax.validation.Valid;

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

import br.com.afroyou.model.Postagem;
import br.com.afroyou.repository.PostagemRepository;

@RestController
@RequestMapping("/servico")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

	@Autowired
	private PostagemRepository postagemRepository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> getall() {
		return ResponseEntity.ok(postagemRepository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> getbyid(@PathVariable Long id){
		return postagemRepository.findById(id).map(r -> ResponseEntity.ok(r))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/busca/{palavraChave}")
	public ResponseEntity<List<Postagem>> getAll(@PathVariable String palavraChave) {
		return ResponseEntity.ok(postagemRepository.findAllBypalavrachaveContainingIgnoreCase(palavraChave));
	}
	@PostMapping
	public ResponseEntity<Postagem> postProduto (@Valid @RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
	}
	@PutMapping
	public ResponseEntity<Postagem> putPostagem (@Valid @RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
	}
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable Long id) {
		postagemRepository.deleteById(id);
	}
	
}
