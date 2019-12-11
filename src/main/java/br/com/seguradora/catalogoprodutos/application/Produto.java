package br.com.seguradora.catalogoprodutos.application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private Integer ramoSusep;
	private Boolean ativo;
	
	public Produto() {
	}
	
	public Produto(String nome, String descricao, Integer ramoSusep, Boolean ativo) {
		this.nome = nome;
		this.descricao = descricao;
		this.ramoSusep = ramoSusep;
		this.ativo = ativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getRamoSusep() {
		return ramoSusep;
	}

	public void setRamoSusep(Integer ramoSusep) {
		this.ramoSusep = ramoSusep;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", ramoSusep=" + ramoSusep
				+ ", ativo=" + ativo + "]";
	}
	
	
}
