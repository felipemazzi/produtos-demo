package br.com.seguradora.catalogoprodutos.application;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

	public Produto adicionar(Produto produto);
	public List<Produto> listar(Optional<Boolean> ativo, Optional<Integer> ramoSusep);
	public Produto obter(Integer idProduto);
	public Produto inativar(Integer idProduto);
	public Produto reativar(Integer idProduto);
}
