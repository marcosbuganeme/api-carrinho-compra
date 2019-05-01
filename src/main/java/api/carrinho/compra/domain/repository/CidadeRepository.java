package api.carrinho.compra.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.carrinho.compra.domain.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
