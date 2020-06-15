package br.com.alura.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.alura.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<AgendamentoEmail> listarAgendamentoEmail() {
		return entityManager.createQuery("SELECT a FROM AgendamentoEmail a", AgendamentoEmail.class).getResultList();
	}

	public void salvarAgendamentoEmail(AgendamentoEmail agendamentoEmail) {
		entityManager.persist(agendamentoEmail);
	}

	public List<AgendamentoEmail> listarAgendamentosEmailPorEmail(String email) {
		Query query = entityManager.createQuery(
				"SELECT a FROM AgendamentoEmail a where a.email = :email and a.enviado = false ",
				AgendamentoEmail.class);

		query.setParameter("email", email);

		return query.getResultList();

	}

	public List<AgendamentoEmail> listarAgendamentosEmailNaoEnviados() {
		Query query = entityManager.createQuery("SELECT a FROM AgendamentoEmail a WHERE a.enviado = false",
				AgendamentoEmail.class);

		return query.getResultList();

	}

}
