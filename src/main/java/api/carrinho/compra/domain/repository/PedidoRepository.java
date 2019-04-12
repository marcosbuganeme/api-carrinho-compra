package api.carrinho.compra.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.carrinho.compra.domain.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}