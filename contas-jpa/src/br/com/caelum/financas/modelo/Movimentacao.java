package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQuery(query = "select avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao = :pTipo group by day(m.data), month(m.data), year(m.data)", name = "MediasPorDiaETipo")

@Entity
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal valor;

	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;

	private String descricao;

	@ManyToOne
	private Conta conta;

	@ManyToMany
	private List<Categoria> categorias;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public String toString() {
		return "Movimentacao [id=" + id + ", valor=" + valor + ", tipoMovimentacao=" + tipoMovimentacao + ", data="
				+ data + ", descricao=" + descricao + ", conta=" + conta + ", categorias=" + categorias + "]";
	}

}

/*
 * 
 * Devemos ent�o anotar o atributo com @Temporal, depois definir o par�metro de
 * precis�o desejado (TemporalType). Aqui, temos tr�s op��es:
 * 
 * DATE: somente a data, sem a hora; TIME: somente a hora, sem data; TIMESTAMP:
 * tanto data quanto hora.
 * 
 * @Temporal(TemporalType.TIMESTAMP) private Calendar data;
 * 
 * 
 * 
 * O interessante nisso tudo � que o select � processado pelo Hibernate assim
 * que ele � iniciado. Caso fa�amos alguma altera��o no modelo sem replic�-la na
 * query, seremos avisados de antem�o. Vamos fazer este teste, alterando valor
 * para valor2 no c�digo abaixo, em Movimentacao:
 * 
 * 
 * Com o JPA, trabalhamos mais orientados � objetos, fazendo as buscas em cima
 * do nosso modelo. Pensando assim, poderia fazer sentido manter as consultas
 * junto �s entidades. Fazemos isso com @NamedQuery.
 * 
 * 
 * Ser� que os @NamedQuery � o pai dos repositores?
 * 
 */