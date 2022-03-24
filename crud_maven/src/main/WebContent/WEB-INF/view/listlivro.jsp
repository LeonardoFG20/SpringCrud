<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

<h1>Lista de Livros</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Nome</th><th>Editar</th><th>Deletar</th></tr>
    <c:forEach var="livro" items="${list}"> 
    <tr>
    <td>${livro.id}</td>
    <td>${livro.nome}</td>
    <td><a href="edit/${livro.id}">Editar</a></td>
    <td><a href="delete/${livro.id}">Deletar</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="addlivro">Adicionar Livro</a>

</body>
</html>