package api.carrinho.compra.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import api.carrinho.compra.domain.model.shared.DomainModel;

@Entity
@Table(name = "produto")
public class Produto extends DomainModel<Long> {

	private String descricao;
	private Double preco;
	private List<Categoria> categorias;

	{
		categorias = new ArrayList<>(3);
	}

	@NotBlank(message = "Descrição é obrigatório")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@NotNull(message = "Preço é obrigatório")
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "produto_categoria",
			   joinColumns = @JoinColumn(name = "id_produto", foreignKey = @ForeignKey(name = "fk_produto_categoria")),
			   inverseJoinColumns = @JoinColumn(name = "id_categoria", foreignKey = @ForeignKey(name = "fk_categoria_produto")))
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
}