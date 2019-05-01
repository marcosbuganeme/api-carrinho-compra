package api.carrinho.compra.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import api.carrinho.compra.domain.model.shared.DomainModel;

@Entity
@Table(name = "categoria")
public class Categoria extends DomainModel<Long> {

	private String nome;
	private List<Produto> produtos;

	{
		produtos = new ArrayList<>(5);
	}

	@NotBlank(message = "Nome é obrigatório")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToMany(mappedBy = "categorias")
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void adicionar(Produto produto) {
		produtos.add(produto);
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}