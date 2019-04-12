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

import api.carrinho.compra.domain.model.Pedido;
import api.carrinho.compra.domain.service.PedidoService;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {

	private @Autowired PedidoService pedidoService;

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Pedido pedido) {

		Pedido pedidoSalvo = pedidoService.save(pedido);

		return ResponseEntity.ok(pedidoSalvo); 
	}

	@GetMapping("{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id) {

		Optional<Pedido> pedido = pedidoService.findById(id);

		return ResponseEntity.of(pedido);
	}

	@GetMapping
	public ResponseEntity<?> buscarTodosPedidos() {

		List<Pedido> pedidos = pedidoService.findAll();

		return ResponseEntity.ok(pedidos);
	}

	@GetMapping("paginados")
	public ResponseEntity<?> buscarTodosPedidosPaginados(@PageableDefault Pageable pageable) {

		Page<Pedido> page = pedidoService.findAll(pageable);

		return ResponseEntity.ok(page);
	}
}