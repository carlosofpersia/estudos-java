<%@ page language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Date"%>
<%@page import="org.hibernate.*" %>
<%@page import="org.hibernate.cfg.*" %>
<%@page import="br.com.entities.Eventos" %>

<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="../../public/estilo.css" type="text/css" rel="stylesheet" >
	<title>Gravar Eventoss</title>

</head>
<body>

<h2>Gravar Eventos do curso do Hibernate</h2>

<%

//http://localhost:8080/curso-java-um/pages/eventos/gravarEventos.jsp?idevento=1&evento=Celulares

int idevento = 0;
String evento = "";

if ( ( request.getParameter("idevento") != null ) 
		&& ( request.getParameter("evento") != null ) ) {
	try {

		idevento = Integer.parseInt(request.getParameter("idevento"));
		evento = request.getParameter("evento");

		SessionFactory sf;
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		/*********************/
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		/*********************/
		Eventos c = new Eventos();
		c.setIdEvento( idevento );
		c.setEvento( evento );
		c.setDataHora( new Date() );
		/*********************/
		s.saveOrUpdate(c);
		tx.commit();
		s.close();

		out.println("<p><span class='success'>Gravou</span></p>");

	} catch (Exception x) {
		out.println(x.getMessage());
	}
} else {
	out.println("<p><span class='error'>Não Gravou</span></p>");
}

%>


</body>
</html>