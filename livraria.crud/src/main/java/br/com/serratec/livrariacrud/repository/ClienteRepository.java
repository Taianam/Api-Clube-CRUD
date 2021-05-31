package br.com.serratec.livrariacrud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.livrariacrud.model.Cliente;
import br.com.serratec.livrariacrud.model.Produto;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Optional<Cliente> findById(Long id);
	Optional<Cliente> findByNome(String nome);
}
