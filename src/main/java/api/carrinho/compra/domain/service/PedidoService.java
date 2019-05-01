package api.carrinho.compra.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import api.carrinho.compra.domain.model.Cliente;
import api.carrinho.compra.domain.model.ItemPedido;
import api.carrinho.compra.domain.model.Pedido;
import api.carrinho.compra.domain.model.Produto;
import api.carrinho.compra.domain.repository.PedidoRepository;
import api.carrinho.compra.domain.service.exceptions.ResourceNotFoundException;

public @Service class PedidoService {

	private @Autowired ProdutoService produtoService;
	private @Autowired ClienteService clienteService;
	private @Autowired PedidoRepository pedidoRepository;

	@Transactional
	public Pedido criar(Pedido pedido) {

		return validaClienteDo(pedido)
				.prepara(pedido)
					.e()
				.salva(pedido);
	}

	public Optional<Pedido> findById(Long id) {

		return pedidoRepository.findById(id);
	}

	public List<Pedido> findAll() {

		return pedidoRepository.findAll();
	}

	public Page<Pedido> findAll(Pageable pageable) {

		return pedidoRepository.findAll(pageable);
	}

	private PedidoService validaClienteDo(Pedido pedido) {

		Cliente cliente = clienteService
								.findById(pedido.getCliente().getId())
								.orElseThrow(resourceNotFoundException("cliente"));

		pedido.setCliente(cliente);

		return this;
	}

	private PedidoService prepara(Pedido pedido) {

		for (ItemPedido item : pedido.getItens()) {

			Produto produtoVerificado = verificaProdutoDo(item);
			ItemPedido itemAtualizado = item
										.adiciona(produtoVerificado)
										.calculaPrecoProduto()
										.e()
										.adiciona(pedido);

			pedido.adiciona(itemAtualizado);
		}

		pedido.fecharPedido();

		return this;
	}

	private Pedido salva(Pedido pedido) {

		return pedidoRepository.save(pedido);
	}

	private Produto verificaProdutoDo(ItemPedido item) {

		return produtoService
					.findById(item.getProduto().getId())
					.orElseThrow(resourceNotFoundException("produto"));
	}

	private Supplier<ResourceNotFoundException> resourceNotFoundException(String resource) {

		String mensagem = String.format("%s não existe", StringUtils.capitalize(resource));
		return () -> new ResourceNotFoundException(mensagem);
	}

	private PedidoService e() { return this; }
}