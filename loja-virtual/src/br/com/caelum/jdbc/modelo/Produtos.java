package br.com.caelum.jdbc.modelo;

public class Produtos {

	private Integer id;
	private String nome;
	private String descricao;

	public Produtos(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
	}

}
