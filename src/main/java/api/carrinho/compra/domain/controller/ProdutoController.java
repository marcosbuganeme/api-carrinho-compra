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

import api.carrinho.compra.domain.model.Produto;
import api.carrinho.compra.domain.service.ProdutoService;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

	private @Autowired ProdutoService produtoService;

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Produto produto) {

		Produto produtoSalvo = produtoService.save(produto);

		return ResponseEntity.ok(produtoSalvo);
	}

	@GetMapping("{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id) {

		Optional<Produto> produto = produtoService.findById(id);

		return ResponseEntity.of(produto);
	}

	@GetMapping
	public ResponseEntity<?> buscarTodosPedidos() {

		List<Produto> produtos = produtoService.findAll();

		return ResponseEntity.ok(produtos);
	}

	@GetMapping("paginados")
	public ResponseEntity<?> buscarTodosPedidosPaginados(@PageableDefault Pageable pageable) {

		Page<Produto> page = produtoService.findAll(pageable);

		return ResponseEntity.ok(page);
	}
}