package api.carrinho.compra.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.carrinho.compra.domain.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}