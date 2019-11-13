/**
 * 
 */
package br.com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.rmi.ServerException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bo.GerenciarEventos;

/**
 * @author carlossantos
 *
 */
public class GravarEvento extends HttpServlet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5006623989174003516L;

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServerException, IOException {

		String evento = request.getParameter("evento");
		String dataEvento = request.getParameter("dataEvento");

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);

        Date dataHora = new Date();
        try {
			dataHora = format.parse(dataEvento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");

		out.println("<head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		out.println("<LINK href='public/estilo.css' type='text/css' rel='stylesheet' />");
		out.println("<title>Gravando Eventos no Hibernate</title>");
		out.println("</head>");

		out.println("<body>");
		out.println("<h2>Gravando Eventos no Hibernate</h2>");
		out.println("Evento: " + evento + "");
		out.println("Data: " + dataEvento + "");

		GerenciarEventos c = new GerenciarEventos();
		c.salvarEvento(evento, dataHora);

		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
