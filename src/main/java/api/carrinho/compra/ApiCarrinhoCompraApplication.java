package api.carrinho.compra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@SpringBootApplication
public class ApiCarrinhoCompraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCarrinhoCompraApplication.class, args);
	}
}