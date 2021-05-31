package br.com.serratec.livrariacrud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.serratec.livrariacrud.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	Optional<Produto> findById(Long id);

}