<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="../../public/estilo.css" type="text/css" rel="stylesheet" >
	<title>Gravar Eventos</title>

</head>
<body bgcolor="white">

<table border="0" align="center">

	<tr>
		<td align="center">
			Adicionar Novo Evento
		</td>
	</tr>

<tr>
<td align="center">
	<form action="gravarEvento" method="get">
		<span>
			<label for="evento">Evento:</label>
			<input type="text" name="evento" value="" id="evento" />
		</span>
		<br/>
		<span>
			<label for="dataEvento">Data:</label>
			<input type="text" name="dataEvento" value="" id="dataEvento" />
		</span>
		<br/>
		<span>
			<input type="submit" name="incluir" value="Salvar" />
		</span>
	</form>
</td>
</tr>

</table>

</body>
</html>