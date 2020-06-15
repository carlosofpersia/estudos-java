package br.com.alura.timer;

import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import br.com.alura.business.AgendamentoEmailBusiness;
import br.com.alura.entity.AgendamentoEmail;

@Singleton
public class AgendamentoEmailTimer {

	@Inject
	private AgendamentoEmailBusiness agendamentoEmailBusiness;

	@Schedule(hour = "*", minute = "10")
	public void enviarEmailsAgendados() {
		List<AgendamentoEmail> agendamentoEmails = agendamentoEmailBusiness.listarAgendamentosEmailNaoEnviados();
		agendamentoEmails.stream().forEach(
				agendamentoEmail -> 
						agendamentoEmailBusiness.enviarEmail(agendamentoEmail));
	}

}

/**
 * Curso EJB, Aula 5 - EJB TIMER
 * 
 * @Singleton - Ao anotar uma classe que é um EJB Timer, o contexto Java EE
 *            controla o processamento para que não haja dois processamentos em
 *            paralelo.
 * 
 *            minute = "0,10, 20, 30, 40, 50" ou minute = "*" para todo minuto
 *            rodar
 * 
 * 
 *            Nesta aula, aprendemos: A criar um EJB @Singleton A agendar a
 *            execução de um método com EJB Timer e @Schedule Que @Schedule
 *            recebe expressões cron para definir o agendamento A usar @Resource
 *            para a injeção de um recurso, como a javax.mail.Session A enviar
 *            e-mails com JavaMail AgendamentoEmail agEmail = new
 *            AgendamentoEmail(); agEmail.setAssunto("Assunt");
 *            agEmail.setEmail("carloseduardophp@gmail.com");
 *            agEmail.setEnviado(false); agEmail.setMensagem("Mensagem");
 *            agendamentoEmailBusiness.enviarEmail(agEmail);
 * 
 * 
 */
