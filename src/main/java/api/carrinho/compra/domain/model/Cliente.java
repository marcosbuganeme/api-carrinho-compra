package api.carrinho.compra.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cliente")
public class Cliente {

	private Long id;
	private String nome;
	private String email;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotBlank(message = "Informe o nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Email(message = "E-mail inválido")
	@NotBlank(message = "Informe o nome")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}