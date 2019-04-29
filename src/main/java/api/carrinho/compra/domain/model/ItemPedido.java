package api.carrinho.compra.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import api.carrinho.compra.domain.model.shared.DomainModel;

@Entity
public class ItemPedido extends DomainModel<Long> {

	private Pedido pedido;
	private Produto produto;
	private Integer quantidade;
	private BigDecimal desconto;
	private BigDecimal precoTotal;

	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade) {

		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
		this.desconto = BigDecimal.ZERO;
		this.precoTotal = BigDecimal.ZERO;
	}

	public void atualizarQuantidade(Integer novaQuantidade) {

		this.quantidade = novaQuantidade;
		calculaPrecoProduto();
	}

	public ItemPedido calculaPrecoProduto() {

		if (produto.getPreco() == null)
			throw new IllegalArgumentException("Cálculo não foi processado porquê o produto não consta preço");

		precoTotal = new BigDecimal(produto.getPreco() * quantidade);

		return this;
	}

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_pedido")
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public ItemPedido adiciona(Pedido pedido) {

		setPedido(pedido);

		return this;
	}

	@ManyToOne
	@JoinColumn(name = "id_produto")
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ItemPedido adiciona(Produto produto) {

		setProduto(produto);

		return this;
	}

	@NotNull(message = "Quantidade do produto é obrigatório")
	@Min(message = "No mínimo um (1) deve ser selecionado", value = 1)
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	@NotNull(message = "Preço do produto não informado")
	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public ItemPedido e() {
		return this;
	}	
}