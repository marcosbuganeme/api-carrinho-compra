package api.carrinho.compra.domain.model.shared;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class DomainModel<ID> {

	private ID id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public @Override int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public @Override boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		DomainModel other = (DomainModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}