package br.com.afroyou.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.afroyou.model.Postagem;
import br.com.afroyou.model.Usuario;
import br.com.afroyou.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getall() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	@PostMapping
	public ResponseEntity<Usuario> postUsuario (@Valid @RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
	}
	@PutMapping
	public ResponseEntity<Usuario> putUsuario (@Valid @RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
}
}
