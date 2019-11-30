package br.com.alura.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.alura.business.AgendamentoEmailBusiness;
import br.com.alura.entity.AgendamentoEmail;

@Path("/agendamentoEmail")
public class AgendamentoEmailResource {

	@Inject
	private AgendamentoEmailBusiness agendamentoEmailBusiness;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarAgendamentoEmail() {

		// http://localhost:8080/agendamentoEmail-0.0.1-SNAPSHOT/resources/agendamentoEmail

		List<AgendamentoEmail> emails = agendamentoEmailBusiness.listarAgendamentosEmail();

		return Response.ok(emails).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarAgendamentoEmail(AgendamentoEmail agendamentoEmail) {

		// http://localhost:8080/agendamentoEmail-0.0.1-SNAPSHOT/resources/agendamentoEmail
		//http://localhost:8080/resources/agendamentoEmail - mudou a URL com o recurso jboss-web.xml 
		//pagina http://localhost:8080/
		
		agendamentoEmailBusiness.salvarAgendamentosEmail(agendamentoEmail);

		return Response.status(201).build();
	}

}
