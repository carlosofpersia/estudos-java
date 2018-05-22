<%@ page language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.*"%>
<%@page import="org.hibernate.*" %>
<%@page import="org.hibernate.cfg.*" %>
<%@page import="br.com.bo.GerenciarEventos" %>

<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="../../public/estilo.css" type="text/css" rel="stylesheet" >
	<title>Listar Eventos</title>

</head>
<body bgcolor="white">

<table border="0" align="center" cellpadding="0" cellspacing="0" width="500px">
<caption>Tabela Listar Eventos</caption>
<thead>
	<tr>
		<th width="20%">#</th>
		<th width="40%">Evento</th>
		<th width="40%">Data</th>
	</tr>
</thead>
<tbody>

<%
GerenciarEventos ge = new GerenciarEventos();
List<br.com.entities.Eventos> lista = ge.listarEventos();

String tabela = "";

for (int i = 0; i < lista.size(); i++) {

	br.com.entities.Eventos c = (br.com.entities.Eventos)lista.get(i);
	int idEvento = c.getIdEvento();
	String evento = c.getEvento();
	Date dataHora = c.getDataHora();

	String corSim = "";
	if (i % 2 == 0) {
		corSim = "background:#f0f0f0";
	}
	
	tabela += "<tr style="+corSim+">";
	tabela += "<td width='20%' align='center'>"+idEvento+"</td>";
	tabela += "<td width='40%'>"+evento+"</td>";
	tabela += "<td width='40%'>"+dataHora+"</td>";
	tabela += "</tr>";
}
out.println(tabela);
%>
</tbody>
<tfoot>
	<tr>
		<td colspan="3" align="right">Total <%out.println(lista.size()); %></td>
	</tr>
</tfoot>

</table>

</body>
</html>