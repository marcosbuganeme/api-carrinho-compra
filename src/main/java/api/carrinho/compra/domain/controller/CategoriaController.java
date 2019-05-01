package api.carrinho.compra.domain.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import api.carrinho.compra.domain.model.Categoria;
import api.carrinho.compra.domain.service.CategoriaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {

	private @Autowired CategoriaService categoriaService;

	@PostMapping
    @ApiOperation(value = "Criar uma nova categoria", response = Categoria.class)
	public ResponseEntity<?> salvar(@Valid @RequestBody Categoria categoria, UriComponentsBuilder uriBuilder) {

		Categoria categoriaSalva = categoriaService.salvar(categoria);

        URI location = uriBuilder
					        .path("api/categorias/{id:\\d+}")
					        .buildAndExpand(categoriaSalva.getId())
					        .toUri();

		return ResponseEntity
					.created(location)
					.body(categoriaSalva);
	}
	
	@PutMapping("{id:\\d+}")
	@ApiOperation(value = "Editar uma categoria", response = Categoria.class)
	public ResponseEntity<?> editar(@PathVariable("id") Long id, @Valid @RequestBody Categoria categoria) {

		Categoria categoriaAtualizada = categoriaService.update(id, categoria);

		return ResponseEntity.ok(categoriaAtualizada);
	}

    @GetMapping("{id:\\d+}")
    @ApiOperation(value = "Recupera uma categoria pelo seu identificador", response = Categoria.class)
	public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id) {

		Optional<Categoria> categoria = categoriaService.findById(id);

		return ResponseEntity.of(categoria);
	}

	@GetMapping
	@ApiOperation(value = "Recupera todos as categorias", response = Categoria[].class)
	public ResponseEntity<?> buscarTodasCategorias() {

		List<Categoria> categorias = categoriaService.findAll();

		return ResponseEntity.ok(categorias);
	}

	@GetMapping("paginados")
	@ApiOperation(value = "Recupera todos os produtos de forma paginada", response = Page.class)
	public ResponseEntity<?> buscarTodasCategoriasPaginados(@PageableDefault Pageable pageable) {

		Page<Categoria> page = categoriaService.findAll(pageable);

		return ResponseEntity.ok(page);
	}
}