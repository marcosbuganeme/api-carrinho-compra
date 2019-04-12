package api.carrinho.compra.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import api.carrinho.compra.domain.model.Cliente;
import api.carrinho.compra.domain.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional
	public Cliente save(Cliente cliente) {

		return clienteRepository.save(cliente);
	}

	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}

	public List<Cliente> findAll() {

		return clienteRepository.findAll();
	}

	public Page<Cliente> findAll(Pageable pageable) {

		return clienteRepository.findAll(pageable);
	}
}