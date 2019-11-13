<%@ page language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Date"%>
<%@page import="org.hibernate.*" %>
<%@page import="org.hibernate.cfg.*" %>
<%@page import="br.com.entities.Categoria" %>

<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="../../public/estilo.css" type="text/css" rel="stylesheet" >
	<title>Gravar Categorias</title>

</head>
<body>

<h2>Gravar Categorias do curso do Hibernate</h2>

<%

//http://localhost:8080/curso-java-um/pages/categoria/gravarCategorias.jsp?idcategoria=1&categoria=Celulares

int idcategoria = 0;
String categoria = "";

if ( ( request.getParameter("idcategoria") != null ) 
		&& ( request.getParameter("categoria") != null ) ) {
	try {

		idcategoria = Integer.parseInt(request.getParameter("idcategoria"));
		categoria = request.getParameter("categoria");

		SessionFactory sf;
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		/*********************/
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		/*********************/
		Categoria c = new Categoria();
		c.setIdCategoria( idcategoria );
		c.setNome( categoria );
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