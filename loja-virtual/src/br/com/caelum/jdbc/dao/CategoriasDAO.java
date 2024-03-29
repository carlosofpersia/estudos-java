package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.modelo.Categorias;
import br.com.caelum.jdbc.modelo.Produtos;

public class CategoriasDAO {

	private final Connection conn;

	public CategoriasDAO(Connection conn) {
		this.conn = conn;
	}

	public List<Categorias> lista() throws SQLException {

		List<Categorias> categorias = new ArrayList<>();
		String sql = "select * from Categoria";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.execute();

			try (ResultSet resultSet = stmt.getResultSet()) {
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String nome = resultSet.getString("nome");

					Categorias categoria = new Categorias(id, nome);

					categorias.add(categoria);
				}
			}
		}
		return categorias;
	}

	public List<Produtos> listaN1NaoNormalizada(Categorias categoria) throws SQLException {
		List<Produtos> produtos = new ArrayList<>();
		String sql = "select * from Produto where categoria_id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, categoria.getId());
			stmt.execute();

			try (ResultSet resultSet = stmt.getResultSet()) {
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String nome = resultSet.getString("nome");
					String descricao = resultSet.getString("descricao");

					Produtos produto = new Produtos(nome, descricao);
					produto.setId(id);

					produtos.add(produto);
				}
			}

		}
		return produtos;
	}

	public List<Categorias> listaComProdutos() throws SQLException {
		List<Categorias> categorias = new ArrayList<>();
		Categorias ultima = null;

		String sql = "select c.id as c_id, c.nome as c_nome, \r\n" + "    p.id as p_id, p.nome as p_nome, \r\n"
				+ "    p.descricao as p_descricao from Categoria as c \r\n"
				+ "join Produto as p on p.categoria_id = c.id order by c.id\r\n";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("c_id");
					String nome = rs.getString("c_nome");
					if (ultima == null || !ultima.getNome().equals(nome)) {
						Categorias categoria = new Categorias(id, nome);
						categorias.add(categoria);
						ultima = categoria;
					}
					int idDoProduto = rs.getInt("p_id");
					String nomeDoProduto = rs.getString("p_nome");
					String descricaoDoProduto = rs.getString("p_descricao");
					Produtos p = new Produtos(nomeDoProduto, descricaoDoProduto);
					p.setId(idDoProduto);
					ultima.adiciona(p);
				}
			}
		}

		return categorias;
	}
}

/*
 * 
 * 
 * Tome cuidado com um poss�vel bug do Eclipse, que n�o passa o par�metro
 * Statement automaticamente. Neste caso, adicione o par�metro voc� mesmo.
 * 
 * 
 * 
 * 
 * listaN1NaoNormalizada = Mas quantas queries executamos? Uma? Duas? Quatro.
 * Note que executamos uma primeira query para trazer todas as categorias.
 * Depois disso executamos uma query para cada categoria, isto �: mais 3
 * queries. Se nosso sistema possui 1000 categorias, executar�amos 1001 queries.
 * Estamos executando N+1 queries, onde N � o n�mero de elementos retornados
 * pela primeira pesquisa. Isto � muito ruim, uma vez que cada pesquisa tem que
 * ir e voltar de um sistema remoto, serializando dados etc.
 * 
 * 
 * 
 * 
 * listaComProdutos = com uma �nica query e um join trouxemos todas as
 * categorias com todos os produtos, evitando o problema do N+1:
 * 
 * 
 * 
 * 
 * O JDBC acaba nos dando controle total sobre o que desejamos fazer com nossas
 * conex�es e quando necess�rio podemos fazer a query que carrega somente as
 * categorias ou a query que busca tanto elas quanto os produtos. Para evitar
 * diversas dessas configura��es padr�es, e minimizar a repeti��o de c�digo
 * entre projetos e entre classes, surgiram diversas bibliotecas de mapeamento
 * entre nossos modelos orientado a objetos e o mundo relacional. S�o as
 * ferramentas de mapeamento objeto relacional (Object Relational Mapping: ORM).
 * Entre elas destacam-se no mundo Java a implementa��o Hibernate e a
 * especifica��o JPA.
 * 
 * Mesmo assim, o problema do N+1 � muito famoso e at� mesmo o mal uso de tais
 * bibliotecas pode causar efeitos negativos em uma aplica��o.
 * 
 * Fa�a a escolha da biblioteca que deseja utilizar (JDBC, Hibernate, JPA etc)
 * de acordo com as necessidades de seu projeto e otimize as queries tamb�m de
 * acordo com aquilo que voc� e sua equipe precisam.
 * 
 * 
 * 
 * ---------------------------------
 * 
 * A otimiza��o � um passo complicado e trabalhoso. Quando devemos otimizar
 * nossas queries?
 * 
 * VER OPINI�O DO INSTRUTOR Opini�o do instrutor
 * 
 * "A otimiza��o prematura � a raiz de todos os males."
 * 
 * Evitamos otimizar as queries at� o momento em que mostramos numericamente que
 * elas est�o ou atrapalhar�o nosso sistema. Enquanto elas n�o s�o um problema,
 * otimizar prematuramente pode ser complicar um c�digo e deix�-lo dif�cil de se
 * manter. Encontrar o momento adequado - quando vale a pena complicar o c�digo
 * com uma otimiza��o - � um desafio.
 * 
 * 
 * 
 * 
 * 
 **/