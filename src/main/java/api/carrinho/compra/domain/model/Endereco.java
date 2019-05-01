package api.carrinho.compra.domain.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import api.carrinho.compra.domain.model.shared.DomainModel;

@Entity
@Table(name = "endereco")
public final class Endereco extends DomainModel<Long> {

	private String numero;
	private String complemento;
	private String bairro;
	private String cep;

	private Cliente cliente;
	private Cidade cidade;

	@NotBlank(message = "Número é obrigatório")
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@NotBlank(message = "Bairro é obrigatório")
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@NotBlank(message = "CEP é obrigatório")
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_cliente", foreignKey = @ForeignKey(name = "fk_endereco_cliente"))
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@ManyToOne
	@JoinColumn(name = "id_cidade", foreignKey = @ForeignKey(name = "fk_endereco_cidade"))
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}