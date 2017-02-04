<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<strong>Bem vindo  
	<!-- ele procura no response se nao tiver nada la pega na session -->
		<c:if test="${not empty usuarioLogado}">
			 ${usuarioLogado.email} 
		</c:if>
		ao nosso gerenciador de empresas!</strong>
	<br />
	<hr>
	<form action="executa?tarefa=BuscaEmpresa" method="post">
		Filtro: <input type="text" name="filtro" /> <input type="submit"
			value="Buscar" />
	</form>
	<hr>
	<form action="executa?tarefa=NovaEmpresa" method="post">
	    Nome: <input type="text" name="nome" /><br />
	    <input type="submit" value="Enviar" />
	</form>
	<hr>
	<form action="login" method="post">
		Email: <input type="text" name="email" /><br /> Senha: <input
			type="password" name="senha" /><br /> <input type="submit"
			value="Login" />
	</form>
	<hr>
	<form action="executa?tarefa=Logout" method="post">
	    <input type="submit" value="Logout" />
	</form>
</body>
</html>