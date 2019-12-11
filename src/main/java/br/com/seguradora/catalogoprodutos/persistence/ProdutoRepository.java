package br.com.seguradora.catalogoprodutos.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seguradora.catalogoprodutos.application.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	public List<Produto> findByAtivoIs(boolean ativo);
	public List<Produto> findByRamoSusep(Integer ramoSusep);
	public List<Produto> findByAtivoAndRamoSusep(Boolean ativo, Integer ramoSusep);
}
