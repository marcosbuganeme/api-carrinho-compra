package api.carrinho.compra.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.carrinho.compra.domain.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
