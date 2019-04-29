package api.carrinho.compra.domain.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import api.carrinho.compra.domain.model.shared.DomainModel;

@Entity
@Table(name = "cliente", uniqueConstraints = @UniqueConstraint(name = "uk_cliente_email", 
															   columnNames = "email"))
public class Cliente extends DomainModel<Long> {

	private String nome;
	private String email;
	private int pontuacao;
	private String documento;

	private List<Pedido> pedidos;
	private Set<String> telefones;
	private List<Endereco> enderecos;

	{
		pedidos = new ArrayList<>(5);
		telefones = new HashSet<>(2);
		enderecos = new ArrayList<>(2);
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

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	@NotBlank(message = "CPF ou CNPJ deve ser informado")
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@OneToMany
	@JsonIgnore
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void adiciona(Pedido pedido) {
		this.pedidos.add(pedido);
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}