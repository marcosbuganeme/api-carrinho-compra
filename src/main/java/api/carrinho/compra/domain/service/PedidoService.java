package api.carrinho.compra.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import api.carrinho.compra.domain.model.Cliente;
import api.carrinho.compra.domain.model.ItemPedido;
import api.carrinho.compra.domain.model.Pedido;
import api.carrinho.compra.domain.model.Produto;
import api.carrinho.compra.domain.repository.ClienteRepository;
import api.carrinho.compra.domain.repository.PedidoRepository;
import api.carrinho.compra.domain.repository.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public Pedido save(Pedido pedido) {

		prepararCliente(pedido);
		prepararItemPedido(pedido);
		pedido.calcular();

		return pedidoRepository.save(pedido);
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

	private void prepararCliente(Pedido pedido) {

		Cliente cliente = clienteRepository
								.findById(pedido.getCliente().getId())
								.orElseThrow(() -> new IllegalArgumentException("Cliente não existe"));

		pedido.setCliente(cliente);
	}

	private void prepararItemPedido(Pedido pedido) {

		for (ItemPedido item : pedido.getItens()) {

			construirProduto(item);
			item.calcularTotal();
			item.setPedido(pedido);
			pedido.getItens().add(item);
		}
	}

	private void construirProduto(ItemPedido item) {

		Produto produto = produtoRepository
								.findById(item.getProduto().getId())
								.orElseThrow(() -> new IllegalArgumentException("Produto não existe"));

		item.setProduto(produto);
	}
}