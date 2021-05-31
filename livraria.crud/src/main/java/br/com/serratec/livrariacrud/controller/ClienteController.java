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

import br.com.serratec.livrariacrud.model.Cliente;
import br.com.serratec.livrariacrud.model.Produto;
import br.com.serratec.livrariacrud.repository.ClienteRepository;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository _clienteRepository;
	
	@GetMapping
	public List<Cliente> obter() {
		return this._clienteRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> obterPorId(@PathVariable(value = "id") Long id) {
		var idEncontrado = this._clienteRepository.findById(id);
		if (idEncontrado.isPresent()) {
			return new ResponseEntity<Optional<Cliente>>(idEncontrado, HttpStatus.OK);
		} else {
			return new ResponseEntity<Optional<Cliente>>(idEncontrado, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<Optional<Cliente>> obterPornome(@PathVariable(value = "nome") String nome) {
		var nomeEncontrado = this._clienteRepository.findByNome(nome);
		if (nomeEncontrado.isPresent()) {
			return new ResponseEntity<Optional<Cliente>>(nomeEncontrado, HttpStatus.OK);
		} else {
			return new ResponseEntity<Optional<Cliente>>(nomeEncontrado, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente) {
		var clienteAdicionado = _clienteRepository.save(cliente);
		return new ResponseEntity<Cliente>(clienteAdicionado, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable(value="id") Long id,@RequestBody Cliente cliente ) {
		if (id == cliente.getId()) {
			var clienteAtualizado =_clienteRepository.save(cliente);
			cliente.setId(id);
			return new ResponseEntity<Cliente>(clienteAtualizado, HttpStatus.OK);
		}else {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);		
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> deletar(@PathVariable(value = "id") Long id) {
		this._clienteRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 
	}
}
