package api.carrinho.compra.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import api.carrinho.compra.domain.model.shared.DomainModel;

@Entity
@Table(name = "produto")
public class Produto extends DomainModel<Long> {

	private String nome;
	private Double preco;

	@NotBlank(message = "Nome é obrigatório")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotNull(message = "Preço é obrigatório")
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}