package api.carrinho.compra.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import api.carrinho.compra.domain.model.Produto;
import api.carrinho.compra.domain.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Optional<Produto> findById(Long id) {

		return produtoRepository
						.findById(id);
	}

	public List<Produto> findAll() {

		return produtoRepository.findAll();
	}

	public Page<Produto> findAll(Pageable pageable) {

		return produtoRepository.findAll(pageable);
	}
}