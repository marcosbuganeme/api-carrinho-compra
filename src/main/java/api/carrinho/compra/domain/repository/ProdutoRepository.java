package api.carrinho.compra.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.carrinho.compra.domain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}