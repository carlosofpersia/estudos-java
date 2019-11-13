package br.com.servlets;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 * 
 * url: http://localhost:8080/curso-java-um/primeiraServletUrl?param1=testeParam1
 * 
 * 2017-11-29
 */
@WebServlet(name = "primeiraServletName2", urlPatterns = {"/primeiraServletUrl2"})
public class PrimeiraServlet extends HttpServlet {

	private static final long serialVersionUID = 4241631494665038999L;

	@Override
	public void service ( HttpServletRequest request, HttpServletResponse response )
	        throws ServletException, IOException {

	        PrintWriter out = response.getWriter();
	        
	        String param1 = request.getParameter("param1");

        	String nome = "Carlos Eduardo";

        	Date data = new Date();
        	String dataHora = data.toString();

	        // escreve o texto
	        out.println("<html>");
	        out.println("<body>");
	        out.println("<b>Primeira Servlet</b>");
	        out.println("<br/>" + nome);
			out.println("<br/>" + dataHora);
			out.println("<br/>" + param1);
	        out.println("</body>");
	        out.println("</html>");
	}
}