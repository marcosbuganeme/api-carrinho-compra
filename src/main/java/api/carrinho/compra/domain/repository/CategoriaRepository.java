package api.carrinho.compra.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api.carrinho.compra.domain.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	@Query("from Categoria")
	List<Categoria> findAll();
}