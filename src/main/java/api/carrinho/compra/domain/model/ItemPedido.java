package api.carrinho.compra.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import api.carrinho.compra.domain.model.shared.DomainModel;

@Entity
@Table(name = "item_pedido")
public class ItemPedido extends DomainModel<Long> {

	private Pedido pedido;
	private Produto produto;
	private Integer quantidade;
	private BigDecimal precoTotal;

	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade) {

		this.produto = produto;
		this.quantidade = quantidade;
	}

	public void atualizarQuantidade(Integer novaQuantidade) {

		this.quantidade = novaQuantidade;
		calcularTotal();
	}

	public void calcularTotal() {

		if (produto.getPreco() == null)
			throw new IllegalArgumentException("Cálculo não foi processado porquê o produto não consta preço");

		precoTotal.add(new BigDecimal(produto.getPreco() * quantidade));
	}

	@ManyToOne
	@JoinColumn(name = "id_pedido")
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@ManyToOne
	@JoinColumn(name = "id_produto")
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@NotNull(message = "Informe a quantidade do produto")
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@NotNull(message = "Preço do produto não informado")
	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}
}