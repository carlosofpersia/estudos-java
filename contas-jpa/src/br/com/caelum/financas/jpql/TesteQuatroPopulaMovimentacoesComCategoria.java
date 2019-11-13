package br.com.caelum.financas.jpql;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteQuatroPopulaMovimentacoesComCategoria {

	public static void main(String[] args) {

		

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta1 = em.find(Conta.class, 2);
		Conta conta2 = em.find(Conta.class, 3);

		Movimentacao movimentacao1 = new Movimentacao();
		Movimentacao movimentacao2 = new Movimentacao();

		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("Conta de luz - Novembro/2019");
		movimentacao1.setValor(new BigDecimal("566"));
		movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao1.setConta(conta1);

		em.persist(movimentacao1);

		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH, 1);

		movimentacao2.setData(amanha); // amanha
		movimentacao2.setDescricao("Almoco no Restaurante - Dezembro/2019");
		movimentacao2.setValor(new BigDecimal("189.80"));
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setConta(conta1);

		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		
		em.close();

	}
}
