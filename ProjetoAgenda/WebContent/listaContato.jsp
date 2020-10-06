<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Telefone</th>
			<th>Endereço</th>
			<th>Senha</th>
		</tr>
		<c:forEach var="contato" items="${contatos}">
			<tr>
				<td><c:out value="${contato.nome}" /> </td>
				<td><c:out value="${contato.email}" /> </td>
				<td><c:out value="${contato.telefone}" /> </td>
				<td><c:out value="${contato.endereco}" /> </td>
				<td><c:out value="${contato.senha}" /> </td>
			</tr>
		</c:forEach>
	</table><br>
	<a href="cadastroContato.jsp"><button>Cadastrar Novo Contato</button></a><br>
</body>
</html>