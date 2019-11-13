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
			System.out.println("Movimentação: " + movimentacao.getDescricao());
		}

	}

}

/*
 * 
 * Relacionamentos bidirecionais - No mundo orientado a objetos, precisamos
 * explicitamente criar atributos de relacionamentos para que as duas pontas se
 * reconheçam; Neste relacionamento, escolhemos uma parte para ser a "dona" e a
 * outra para ser o "espelho" (mappedBy).
 * 
 * 
 * 
 * 
 * Lazy Loading - Por padrão todos os relacionamentos [...]ToMany são Lazy;
 * Torna mais fácil o problema do N + 1 (Atenção: também é possível ter N + 1
 * com Eager!); Usamos o join fetch para carregar o relacionamento de forma
 * Eager (em uma mesma query) ao usarmos JPQL.
 *
 *
 *
 *
 * Join e produto cartesiano - Ao usarmos join fetch, os resultados aparecem
 * duplicados devido ao produto cartesiano. Para evitá-los, utilizamos a
 * palavra-chave distinct; O join fetch dispara um inner join no banco, o que
 * acaba trazendo apenas as contas com movimentação. Por isso usamos left join
 * fetch, que trará todos os dados da entidade que se encontram ao lado esquerdo
 * do join (no caso, Conta).
 * 
 * 
 */