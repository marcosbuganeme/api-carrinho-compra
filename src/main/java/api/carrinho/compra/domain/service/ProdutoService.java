package api.carrinho.compra.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import api.carrinho.compra.domain.model.Produto;
import api.carrinho.compra.domain.repository.ProdutoRepository;
import api.carrinho.compra.domain.service.exceptions.ResourceNotFoundException;

public @Service class ProdutoService {

	private @Autowired ProdutoRepository produtoRepository;

	@Transactional
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Transactional
	public Produto update(Long id, Produto produto) {

		findById(id)
			.orElseThrow(produtoNaoEncontradoException());

		produto.setId(id);
		return produtoRepository.save(produto);
	}

	@Transactional
	public void delete(Long id) {

		findById(id)
			.orElseThrow(produtoNaoEncontradoException());

		produtoRepository.deleteById(id);
	}

	public Optional<Produto> findById(Long id) {

		return produtoRepository.findById(id);
	}

	public List<Produto> findAll() {

		return produtoRepository.findAll();
	}

	public Page<Produto> findAll(Pageable pageable) {

		return produtoRepository.findAll(pageable);
	}

	private Supplier<ResourceNotFoundException> produtoNaoEncontradoException() {
		return () -> new ResourceNotFoundException("Produto não existe");
	}
}