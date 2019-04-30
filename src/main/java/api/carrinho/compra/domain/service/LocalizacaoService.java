package api.carrinho.compra.domain.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import api.carrinho.compra.domain.model.Cidade;
import api.carrinho.compra.domain.model.Estado;
import api.carrinho.compra.domain.repository.CidadeRepository;
import api.carrinho.compra.domain.repository.EstadoRepository;

public @Service class LocalizacaoService {

	private CidadeRepository cidadeRepository;
	private EstadoRepository estadoRepository;

	public Optional<Cidade> buscaPorIdCidade(Long idCidade) {

		return cidadeRepository.findById(idCidade);
	}

	public Optional<Estado> buscaPorIdEstado(Long idEstado) {

		return estadoRepository.findById(idEstado);
	}
}