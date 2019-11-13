package br.com.caelum.financas.jpa;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteCincoRemoveConta {

	public static void main(String[] args) {

		//java.lang.IllegalArgumentException
		Conta conta = new Conta();
		//conta.setId(1);

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		
		conta = em.find(Conta.class, 1);//resolve problema do detached, pois deixara conta com estado managed
		em.remove(conta);//nesse caso ele é excluido, mas ainda existe na memória

		em.getTransaction().commit();

		em.close();

	}
}
