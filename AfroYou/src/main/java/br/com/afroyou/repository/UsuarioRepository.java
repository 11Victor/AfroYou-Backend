package br.com.afroyou.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.afroyou.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
}

