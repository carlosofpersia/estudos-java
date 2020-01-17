package br.com.alura.business;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import br.com.alura.dao.AgendamentoEmailDAO;
import br.com.alura.entity.AgendamentoEmail;
import br.com.alura.exception.BusinessException;
import br.com.alura.interceptor.Logger;

/*
 * 
 * 
 * 
 * Aula 4 sobre logger, criar a interface interceptor Logger e adiciona-la aqui na classe  através de uma anotação @Logger
 
 *
 *
 *

 * 
 * EJB com Java EE 8: API Rest com WildFly 15
 * Aula 4 - Nesta aula, aprendemos:
Como tratar exceções em uma aplicação que usa EJB
Como criar um interceptador EJB
Como criar a sua própria anotação
Como mapear uma exceção para a view (JSON)
Como escrever mensagens de log usando java.util.logging.Logger
 *
 *
 *
 *
 * @Resource CDI para fazer o lookup da sessão de e-mail do servidor de aplicação - Esta anotação faz o lookup de recursos disponibilizados pelo servidor de aplicação.
 *
 */

@Stateless
@Logger
public class AgendamentoEmailBusiness {

	@Inject
	AgendamentoEmailDAO agendamentoEmailDAO;

	@Resource(lookup = "java:jboss/mail/AgendamentoMailSession")
	private Session sessaoEmail;

	private static String EMAIL_FROM = "mail.smtp.host";
	private static String EMAIL_USER = "mail.smtp.user";
	private static String EMAIL_PASSWORD = "mail.smtp.pass";

	public List<AgendamentoEmail> listarAgendamentosEmail() {

		return agendamentoEmailDAO.listarAgendamentoEmail();
	}

	/*
	 * @Valid = Bean Validation, usa o arquivo ValidationMessages.properties para
	 * mensagens
	 */
	public void salvarAgendamentosEmail(@Valid AgendamentoEmail agendamentoEmail) throws BusinessException {

		if (!agendamentoEmailDAO.listarAgendamentosEmailPorEmail(agendamentoEmail.getEmail()).isEmpty()) {
			// aula 4 ejb - criando uma excessao personalizada e carregando via interceptors
			throw new BusinessException("E-mail já agendado.");
		}

		agendamentoEmail.setEnviado(false);
		agendamentoEmailDAO.salvarAgendamentoEmail(agendamentoEmail);
	}

	public List<AgendamentoEmail> listarAgendamentosEmailNaoEnviados() {

		return agendamentoEmailDAO.listarAgendamentosEmailNaoEnviados();
	}

	public void enviarEmail(AgendamentoEmail agendamentoEmail) {
		try {

			
			System.out.println(sessaoEmail.getProperties());
			
			MimeMessage mensagem = new MimeMessage(sessaoEmail);
			mensagem.setFrom(sessaoEmail.getProperty(EMAIL_FROM));
			mensagem.setRecipients(Message.RecipientType.TO, agendamentoEmail.getEmail());
			mensagem.setSubject(agendamentoEmail.getAssunto());

			mensagem.setText(Optional.ofNullable(agendamentoEmail.getMensagem()).orElse(""));

			Transport.send(mensagem, sessaoEmail.getProperty(EMAIL_USER), sessaoEmail.getProperty(EMAIL_PASSWORD));

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	/*
	 * public List<String> listarAgendamentosEmail() { List<String> emails = new
	 * ArrayList<>(); emails.add("carloseduardophp@gmail.com");
	 * emails.add("carlosofpersia@hotmail.com");
	 * emails.add("batataringosk8@yahoo.com.br"); return emails; }
	 */
}
