package api.carrinho.compra.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import api.carrinho.compra.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Optional<Cliente> findByEmail(String email);
}