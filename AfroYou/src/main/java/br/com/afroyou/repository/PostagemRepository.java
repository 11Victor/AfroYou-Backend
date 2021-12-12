package br.com.afroyou.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.afroyou.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	public List<Postagem> findAllBypalavrachaveContainingIgnoreCase(String palavraChave);
}



