package api.carrinho.compra;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import api.carrinho.compra.Pessoa.Maioridade;

@SpringBootApplication
public class ApiCarrinhoCompraApplication {

	public static void main(String[] args) {
		Map<Maioridade, List<Pessoa>> pessoas = Arrays
												.asList(new Pessoa(28, "marcos", Maioridade.MAIOR), 
														new Pessoa(24, "emilly", Maioridade.MAIOR), 
														new Pessoa(67, "rosalia", Maioridade.MAIOR), 
														new Pessoa(6, "silvia vitória", Maioridade.MENOR), 
														new Pessoa(14, "anne helise", Maioridade.MENOR), 
														new Pessoa(15, "beatriz", Maioridade.MENOR))
												.stream()
												.collect(Collectors.groupingBy(Pessoa::getMaioridade));

		System.out.println(pessoas);
		//SpringApplication.run(ApiCarrinhoCompraApplication.class, args);
	}
}