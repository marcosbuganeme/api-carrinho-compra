package api.carrinho.compra.domain.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import api.carrinho.compra.domain.model.shared.DomainModel;

@Entity
public class Cidade extends DomainModel<Long> {

	private String nome;
	private Estado estado;

	@NotBlank(message = "Cidade é obrigatório")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = false, foreignKey = @ForeignKey(name = "fk_cidade_estado"))
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}