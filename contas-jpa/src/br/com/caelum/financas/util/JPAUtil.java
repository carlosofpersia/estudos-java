package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	/**
	 * Usando HSQLDB
	 */
	// EntityManagerFactory emf = Persistence
	// .createEntityManagerFactory("contas-hsqldb");

	/**
	 * Usando PostgreSQL
	 */
	// EntityManagerFactory emf = Persistence
	// .createEntityManagerFactory("contas-postgres");

	/**
	 * Usando MySQL
	 */

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas-mysql");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
