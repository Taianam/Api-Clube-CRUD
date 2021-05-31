package br.com.serratec.livrariacrud.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.livrariacrud.model.Produto;
import br.com.serratec.livrariacrud.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository _produtoRepository;

	@GetMapping
	public List<Produto> obter() {
		return this._produtoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Produto>> obterPorId(@PathVariable(value = "id") Long id) {
		var idEncontrado = this._produtoRepository.findById(id);
		if (idEncontrado.isPresent()) {
			return new ResponseEntity<Optional<Produto>>(idEncontrado, HttpStatus.OK);
		} else {
			return new ResponseEntity<Optional<Produto>>(idEncontrado, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<Optional<Produto>> obterPornome(@PathVariable(value = "nome") String nome) {
		var nomeEncontrado = this._produtoRepository.findByNome(nome);
		if (nomeEncontrado.isPresent()) {
			return new ResponseEntity<Optional<Produto>>(nomeEncontrado, HttpStatus.OK);
		} else {
			return new ResponseEntity<Optional<Produto>>(nomeEncontrado, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Produto> adicionar(@RequestBody Produto produto) {
		var produtoAdicionado = this._produtoRepository.save(produto);
		return new ResponseEntity<Produto>(produtoAdicionado, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable(value="id") Long id,@RequestBody Produto produto ) {
		
		if (id == produto.getId()) {
			var produtoAtualizado =_produtoRepository.save(produto);
			produto.setId(id);
			return new ResponseEntity<Produto>(produtoAtualizado, HttpStatus.OK);
		}else {
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);		
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> deletar(@PathVariable(value = "id") Long id) {
		this._produtoRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 
	}
}
