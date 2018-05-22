/**
 * 
 */
package br.com.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

/**
 * @author carlossantos
 *
 */
public class EventosServlet extends HttpServlet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -390511027020713879L;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/curso-java";
	static final String USER = "root";
	static final String PASS = "skater";
	
	/*
	 * 
	 * http://localhost:8080/curso-java-um/EventosServlet
	 * 
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void service (HttpServletRequest req, HttpServletResponse res)
	        throws ServletException, IOException {

	    Connection conn = null;
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from eventos"); 

	        PrintWriter pw = res.getWriter();
	        res.setContentType("text/html");

			String tabela = "";

			tabela += "<table>";

			tabela += "<tr>";
			tabela += "<th>#</th>";
			tabela += "<th>evento</th>";
			tabela += "<th>dataHora</th>";
			tabela += "</tr>";
			tabela += "<tr>";
			tabela += "<td></td>";
			tabela += "<td>...</td>";
			tabela += "<td></td>";
			tabela += "</tr>";

	        ResultSet rs = ps.executeQuery();

	        int qtdRows = 0;
	        
        	while(rs.next()) {

				//br.com.entities.Eventos ev = new br.com.entities.Eventos();					
                //List<br.com.entities.Eventos> listEv = new ArrayList<br.com.entities.Eventos>();
                //ev.setIdEvento(rs.getInt("idEvento"));
                //listEv.add(ev);

                int idEvento = rs.getInt("idEvento");
                String evento = rs.getString("evento");
                Date dataHora = rs.getDate("dataHora");

                tabela += "<tr>";
                tabela += "<td>"+idEvento+"</td>";
                tabela += "<td>"+evento+"</td>";
                tabela += "<td>"+dataHora+"</td>";
                tabela += "</tr>";

                qtdRows = rs.getRow();
        	}

        	if( qtdRows == 0  ) {
        		String tabelaElse = "";
	        	tabelaElse += "<tr>";
	        	tabelaElse += "<td></td>";
	        	tabelaElse += "<td>...</td>";
	        	tabelaElse += "<td></td>";
	        	tabelaElse += "</tr>";
	        	pw.println(tabelaElse);
        	}

	        tabela += "<tr style='background:#c8c8c8'>";
        	tabela += "<td>&nbsp;</td>";
        	tabela += "<td>...</td>";
        	tabela += "<td>Total: "+qtdRows+"</td>";
        	tabela += "</tr>";

	        pw.println("</table>");
	        pw.println(tabela);

            rs.close();
            ps.close();
	        pw.close();

	    } catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}

	/**
	 * 
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
	*/
}

