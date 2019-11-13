package br.com.caelum.financas.lazy;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteTresInserirMovimentacao {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		Conta conta = em.find(Conta.class, 3);

		List<Movimentacao> movimentacoes = conta.getMovimentacoes();

		em.close();

		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Movimenta��o: " + movimentacao.getDescricao());
		}

	}

}

/*
 * 
 * Relacionamentos bidirecionais - No mundo orientado a objetos, precisamos
 * explicitamente criar atributos de relacionamentos para que as duas pontas se
 * reconhe�am; Neste relacionamento, escolhemos uma parte para ser a "dona" e a
 * outra para ser o "espelho" (mappedBy).
 * 
 * 
 * 
 * 
 * Lazy Loading - Por padr�o todos os relacionamentos [...]ToMany s�o Lazy;
 * Torna mais f�cil o problema do N + 1 (Aten��o: tamb�m � poss�vel ter N + 1
 * com Eager!); Usamos o join fetch para carregar o relacionamento de forma
 * Eager (em uma mesma query) ao usarmos JPQL.
 *
 *
 *
 *
 * Join e produto cartesiano - Ao usarmos join fetch, os resultados aparecem
 * duplicados devido ao produto cartesiano. Para evit�-los, utilizamos a
 * palavra-chave distinct; O join fetch dispara um inner join no banco, o que
 * acaba trazendo apenas as contas com movimenta��o. Por isso usamos left join
 * fetch, que trar� todos os dados da entidade que se encontram ao lado esquerdo
 * do join (no caso, Conta).
 * 
 * 
 */