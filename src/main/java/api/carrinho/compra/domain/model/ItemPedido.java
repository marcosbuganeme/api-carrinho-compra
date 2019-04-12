package api.carrinho.compra.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

	private Long id;
	private Pedido pedido;
	private Produto produto;
	private Double precoTotal;
	private Integer quantidade;

	public ItemPedido() {}

	public ItemPedido(Produto produto, Integer quantidade) {

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

		precoTotal = produto.getPreco() * quantidade;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public Double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}
}