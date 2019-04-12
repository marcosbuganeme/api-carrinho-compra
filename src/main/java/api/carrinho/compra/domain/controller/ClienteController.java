package api.carrinho.compra.domain.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.carrinho.compra.domain.model.Cliente;
import api.carrinho.compra.domain.service.ClienteService;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

	private @Autowired ClienteService clienteService;

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Cliente cliente) {

		Cliente clienteSalvo = clienteService.save(cliente);

		return ResponseEntity.ok(clienteSalvo);
	}

	@GetMapping("{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id) {

		Optional<Cliente> cliente = clienteService.findById(id);

		return ResponseEntity.of(cliente);
	}

	@GetMapping
	public ResponseEntity<?> buscarTodos() {

		List<Cliente> clientes = clienteService.findAll();

		return ResponseEntity.ok(clientes);
	}

	@GetMapping("paginados")
	public ResponseEntity<?> buscarTodosPaginado(@PageableDefault Pageable pageable) {

		Page<Cliente> page = clienteService.findAll(pageable);

		return ResponseEntity.ok(page);
	}
}