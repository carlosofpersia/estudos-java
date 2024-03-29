package br.com.caelum.financas.jpa;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteOitoContaCliente {

	public void testeUm() {

		Cliente cliente = new Cliente();
		cliente.setNome("Leonardo");
		cliente.setEndereco("Rua Fulano, 123");
		cliente.setProfissao("Professor");

		Conta conta = new Conta();
		conta.setId(3);

		cliente.setConta(conta);

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.persist(cliente);

		em.getTransaction().commit();

		em.close();
	}

	public void testeDois() {

		Cliente cliente = new Cliente();
		cliente.setNome("Leonardo");
		cliente.setEndereco("Rua Fulano, 123");
		cliente.setProfissao("Professor");

		Cliente cliente2 = new Cliente();
		cliente2.setNome("Douglas");
		cliente2.setEndereco("Rua Fulano, 234");
		cliente2.setProfissao("Professor");

		Conta conta = new Conta();
		conta.setId(3);

		cliente.setConta(conta);
		cliente2.setConta(conta);

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.persist(cliente);
		//em.persist(cliente2);//um cliente so pode ter uma unica conta.

		em.getTransaction().commit();
	}

	public static void main(String[] args) {

		TesteOitoContaCliente teste = new TesteOitoContaCliente();
		teste.testeDois();

	}

}
