package api.carrinho.compra.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.carrinho.compra.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}