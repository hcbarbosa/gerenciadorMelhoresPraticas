<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pesquisa</title>
</head>
<body>

	<!-- foi colocado dentro da pasta WEB-INF pois ela fica invisivel via url -->
	<!-- a pasta nao pode ser acessada pelo cliente -->

	Resuldado da busca:
	<br>
	<hr>
	<ul>
	
	<c:forEach var="e" items="${empresas }">
		<li>${e.getId() } : ${e.getNome() }</li>
	</c:forEach>
	
	</ul>
	<a href='http://localhost:8085/gerenciador/'> 
		<span>Voltar</span>
	</a>
</body>
</html>