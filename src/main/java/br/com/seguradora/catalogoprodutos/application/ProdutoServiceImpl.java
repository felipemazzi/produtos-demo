package br.com.seguradora.catalogoprodutos.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seguradora.catalogoprodutos.persistence.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	private ProdutoRepository repository;

	public ProdutoServiceImpl(@Autowired ProdutoRepository repository) {
		this.repository = repository;
	}

	@Override
	public Produto adicionar(Produto produto) {
		produto.setId(0);
		Produto novoProduto = repository.save(produto);
		return novoProduto;
	}

	@Override
	public List<Produto> listar(Optional<Boolean> ativo, Optional<Integer> ramoSusep) {
		if (!ativo.isPresent() && !ramoSusep.isPresent()) {
			return repository.findAll();
		}
		if (!ativo.isPresent() && ramoSusep.isPresent()) {
			return repository.findByRamoSusep(ramoSusep.get());
		}
		if (ativo.isPresent() && !ramoSusep.isPresent()) {
			return repository.findByAtivoIs(ativo.get());
		}
		return repository.findByAtivoAndRamoSusep(ativo.get(), ramoSusep.get());
	}

	@Override
	public Produto obter(Integer idProduto) {
		Optional<Produto> produto = repository.findById(idProduto);
		return produto.isPresent() ? produto.get() : null;
	}

	@Override
	public Produto inativar(Integer idProduto) {
		Produto produto = obter(idProduto);
		if (produto != null) {
			produto.setAtivo(false);
		}
		return repository.save(produto);
	}

	@Override
	public Produto reativar(Integer idProduto) {
		Produto produto = obter(idProduto);
		if (produto != null) {
			produto.setAtivo(true);
		}
		return repository.save(produto);
	}
	
	
}
