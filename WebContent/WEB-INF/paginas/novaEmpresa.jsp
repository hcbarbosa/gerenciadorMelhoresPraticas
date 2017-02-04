<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo</title>
</head>
<body>

	<!-- foi colocado dentro da pasta WEB-INF pois ela fica invisivel via url -->
	<!-- a pasta nao pode ser acessada pelo cliente -->

	Empresa ${ empresa.getNome() } foi adicionada com sucesso. 
	<!-- tambem poderia ser igual o codigo abaixo -->
	<!-- ele é uma expression language, usado para getX() ou isX() -->
	<!-- Empresa empresa.nome()  foi adicionada com sucesso.  -->
	<a href='http://localhost:8085/gerenciador/'>
		<span>Voltar</span>
	</a>
</body>
</html>