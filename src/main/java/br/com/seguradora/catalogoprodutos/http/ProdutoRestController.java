package br.com.seguradora.catalogoprodutos.http;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.seguradora.catalogoprodutos.application.Produto;
import br.com.seguradora.catalogoprodutos.application.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoRestController {

	private ProdutoService service;

	public ProdutoRestController(@Autowired ProdutoService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Produto> adicionar(@RequestBody Produto produto) {
		Produto novoProduto = service.adicionar(produto);
		ResponseEntity<Produto> resposta = new ResponseEntity<Produto>(novoProduto, HttpStatus.CREATED);
		return resposta;
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> listar(@RequestParam("ativo") Optional<Boolean> ativo, @RequestParam("ramoSusep") Optional<Integer> ramoSusep) {
		List<Produto> produtos = service.listar(ativo, ramoSusep);
		ResponseEntity<List<Produto>> resposta = new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
		return resposta;
	}
	
	@GetMapping("/{idProduto}")
	public ResponseEntity<Produto> obter(@PathVariable("idProduto") Integer idProduto) {
		Produto produto = service.obter(idProduto);
		ResponseEntity<Produto> resposta = new ResponseEntity<Produto>(produto, HttpStatus.OK);
		return resposta;
	}
	
	@DeleteMapping("/{idProduto}")
	public ResponseEntity<Produto> inativar(@PathVariable("idProduto") Integer idProduto) {
		Produto produto = service.inativar(idProduto);
		ResponseEntity<Produto> resposta = new ResponseEntity<Produto>(produto, HttpStatus.OK);
		return resposta;
	}
	
	@PutMapping("/{idProduto}")
	public ResponseEntity<Produto> reativar(@PathVariable("idProduto") Integer idProduto) {
		Produto produto = service.reativar(idProduto);
		ResponseEntity<Produto> resposta = new ResponseEntity<Produto>(produto, HttpStatus.OK);
		return resposta;
	}
}
