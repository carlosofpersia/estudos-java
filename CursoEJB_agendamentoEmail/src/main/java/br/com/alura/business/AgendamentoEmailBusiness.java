package br.com.alura.business;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.ejb.ApplicationException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
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
 * 
 *
 *
 * Aula 07
A integrar o EJB com JMS
Que JMS é o padrão Java EE para mensageria
Que uma fila JMS serve como repositório JMS
A injetar uma Queue e usar o JMSContext
A enviar mensagens JMS usando Producer
Como receber mensagens JMS com Message Driven Bean

* Gerenciamento de Transacao 2 formas:

	* CMT: container managed transaction;
		CMT é a marcação implícita, ou declarativa da transação.
			A especificação JTA (Java Transaction API) oferece uma anotação para tal.
		@TransactionAttribute;
		@TransactionManagement(TransactionManagementType.CONTAINER)

	* BMT: Bean Managed Transaction
		BMT é a marcação explícita, ou programática da transação.
			No Bean Managed Transaction usamos o objeto UserTransaction para chamar begin, rollback e commit.
		begin(); rollback(); commit();
		@TransactionManagement(TransactionManagementType.BEAN)
		

O uso de transações é essencial para qualquer sistema que deseja garantir a durabilidade, integridade e consistência dos dados. 
Por esse motivo, o EJB integra uma especificação para trabalhar com transações de alto nível, 
o JTA (Java Transaction API). 
O JTA oferece duas formas de demarcação de transações, Bean-Managed (BMT), e Container-Managed (CMT).

		CMT (Container-Managed) é a marcação implícita, ou declarativa da transação.
			A especificação JTA (Java Transaction API) oferece uma anotação para tal.

		BMT (Bean-Managed) é a marcação explícita, ou programática da transação.
			No Bean Managed Transaction usamos o objeto UserTransaction para chamar begin, rollback e commit.
 *
 *
 *Quando o método inserir for chamado, uma nova transação deve ser criada para este processo. Como podemos configurar a chamada deste método para iniciar sempre uma nova transação?
	Anotando o método com @TransactionAttribute(TransactionAttributeType.REQUIRED_NEW)
	Esta anotação, com este parâmetro, configura o EJB para abrir uma nova transação toda vez que o método é chamado.


Coloquei manualmente, agora o checked vai dar rollback!
@ApplicationException(rollback=true)
public class BusinessException extends Exception



 *
 *
 */

@Stateless
@Logger
@TransactionManagement(TransactionManagementType.CONTAINER)
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
	 * 
	 * @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED) - nao pega transacao ejb, da erro devido a exception, mas salva! nao gerou rollback.
	 * @TransactionAttribute(TransactionAttributeType.REQUIRED) - se nao tiver transacao aberta, ele abre! e da rollback.
	 * 
	 * 
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvarAgendamentosEmail(@Valid AgendamentoEmail agendamentoEmail) throws BusinessException {

		if (!agendamentoEmailDAO.listarAgendamentosEmailPorEmail(agendamentoEmail.getEmail()).isEmpty()) {
			// aula 4 ejb - criando uma excessao personalizada e carregando via interceptors
			throw new BusinessException("E-mail já agendado.");
		}

		agendamentoEmail.setEnviado(false);
		agendamentoEmailDAO.salvarAgendamentoEmail(agendamentoEmail);

		//throw new RuntimeException(); com TransactionAttributeType.NOT_SUPPORTED deu exception, mas salvou.
		//throw new RuntimeException(); com TransactionAttributeType.REQUIRED deu excpetion e gerou um rollback.
		//throw new BusinessException(); 
	}

	public List<AgendamentoEmail> listarAgendamentosEmailNaoEnviados() {

		return agendamentoEmailDAO.listarAgendamentosEmailNaoEnviados();
	}
	
	public void marcarEnviadas(AgendamentoEmail agendamentoEmail) {
		agendamentoEmail.setEnviado(true);
		agendamentoEmailDAO.atualizarAgendamentoEmail(agendamentoEmail);
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
