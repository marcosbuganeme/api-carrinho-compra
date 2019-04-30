package api.carrinho.compra.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import api.carrinho.compra.domain.model.ItemPedido;

@Service
@SessionScope
public class CarrinhoCompraService {

	private List<ItemPedido> itens;

	{
		itens = new ArrayList<>(5);
	}

	public void adicionarItem(ItemPedido item) {

		validaAndExecuta(item, itens::contains, itens::add);
	}

	public void removerItem(ItemPedido item) {

		validaAndExecuta(item, itens::contains, itens::remove);
	}

	private <T> void validaAndExecuta(T objetoDominio, 
									  Predicate<T> condicao, 
									  Consumer<T> acaoExecutada) {

		Optional
			.ofNullable(objetoDominio)
			.filter(condicao)
			.ifPresent(acaoExecutada);
	}
}