package api.carrinho.compra.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import api.carrinho.compra.domain.model.Categoria;
import api.carrinho.compra.domain.repository.CategoriaRepository;
import api.carrinho.compra.domain.service.exceptions.ResourceNotFoundException;

public @Service class CategoriaService {

	private @Autowired CategoriaRepository categoriaRepository;

	@Transactional
	public Categoria salvar(Categoria categoria) {

		return categoriaRepository.save(categoria);
	}

	@Transactional
	public Categoria update(Long id, Categoria categoria) {

		findById(id)
			.orElseThrow(categoriaNotFoundException());

		categoria.setId(id);
		return categoriaRepository.save(categoria);
	}
	
	@Transactional
	public void remove(Long id) {

		Categoria categoria = this.findById(id)
								  .orElseThrow(categoriaNotFoundException());

		categoriaRepository.delete(categoria);
	}

	public Optional<Categoria> findById(Long id) {

		return categoriaRepository.findById(id);
	}

	public List<Categoria> findAll() {

		return categoriaRepository.findAll();
	}

	public Page<Categoria> findAll(Pageable pageable) {

		return categoriaRepository.findAll(pageable);
	}

	private Supplier<ResourceNotFoundException> categoriaNotFoundException() {
		return () -> new ResourceNotFoundException("Categoria não foi encontrada");
	}
}