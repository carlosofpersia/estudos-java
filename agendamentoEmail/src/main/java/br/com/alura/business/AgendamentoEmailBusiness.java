package br.com.alura.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.dao.AgendamentoEmailDAO;
import br.com.alura.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailBusiness {

	@Inject
	AgendamentoEmailDAO agendamentoEmailDAO;

	public List<AgendamentoEmail> listarAgendamentosEmail() {

		return agendamentoEmailDAO.listarAgendamentoEmail();
	}

	/*
	 * @Valid = Bean Validation, usa o arquivo ValidationMessages.properties para mensagens
	 */
	public void salvarAgendamentosEmail(@Valid AgendamentoEmail agendamentoEmail) {

		agendamentoEmail.setEnviado(false);
		agendamentoEmailDAO.salvarAgendamentoEmail(agendamentoEmail);
	}

	/*
	 * public List<String> listarAgendamentosEmail() { List<String> emails = new
	 * ArrayList<>(); emails.add("carloseduardophp@gmail.com");
	 * emails.add("carlosofpersia@hotmail.com");
	 * emails.add("batataringosk8@yahoo.com.br"); return emails; }
	 */
}
