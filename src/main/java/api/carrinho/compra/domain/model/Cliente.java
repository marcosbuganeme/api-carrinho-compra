package api.carrinho.compra.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import api.carrinho.compra.domain.model.shared.DomainModel;

@Entity
@Table(name = "cliente")
public class Cliente extends DomainModel<Long> {

	private String nome;
	private String email;

	public Cliente() {}

	public Cliente(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	@NotBlank(message = "Nome é obrigatório")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Email(message = "E-mail inválido")
	@NotBlank(message = "E-mail é obrigatório")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}