package br.com.serratec.livrariacrud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.serratec.livrariacrud.model.Cliente;
import br.com.serratec.livrariacrud.model.Produto;
import br.com.serratec.livrariacrud.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository _produtoRepository;
	
	@GetMapping
	public List<Produto> obter(){
		return this._produtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Produto> obterPorId(@PathVariable(value="id") Long id){
		return this._produtoRepository.findById(id);
	}
	
//	@GetMapping("/{nome}")
//	public Optional<Produto> obterPornome(@PathVariable(value="nome") String nome){
//		return this._produtoRepository.findByNome(nome);
//	}
//	
	
	@PostMapping
	public Produto adicionar (@RequestBody Produto produto) {
		return this._produtoRepository.save(produto);
	}
	
	@PutMapping("/{id}")
	public Produto atualizar(@PathVariable(value="id") Long id,@RequestBody Produto produto ) {
		produto.setId(id);
		
		return this._produtoRepository.save(produto);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable(value="id") Long id) {
		this._produtoRepository.deleteById(id);
	}
}
