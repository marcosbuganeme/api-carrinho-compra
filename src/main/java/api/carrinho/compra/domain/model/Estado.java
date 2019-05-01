package api.carrinho.compra.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import api.carrinho.compra.domain.model.shared.DomainModel;

@Entity
public final class Estado extends DomainModel<Long> {

	private String nome;
	private List<Cidade> cidades;

	{
		cidades = new ArrayList<>(5);
	}

	@NotBlank(message = "Estado é obrigatório")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "estado")
	public List<Cidade> getCidades() {
		return cidades;
	}

	public void adiciona(Cidade cidade) {
		cidades.add(cidade);
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
}