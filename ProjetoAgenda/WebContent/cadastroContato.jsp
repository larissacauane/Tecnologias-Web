<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
	<form action="CadastroContato" method="POST" >
		Nome: <input type="text" name="nome" id="nome"><br>
		Email: <input type="email" name="email" id="email"><br>
		Telefone: <input type="text" name="telefone" id="telefone"><br>
		Endereço <input name="endereco" id="endereco" type="text"><br>
		Senha <input name="senha" id="senha" type="password"><br><br>
		<input type="submit" value="Cadastrar"><br>
	</form>
	</fieldset><br>
	<a href="menu.jsp"><button>Voltar</button></a><br><br>

</body>
</html>