<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

<h1>Adicionar Livro</h1>
       <form:form method="post" action="save">  
      	<table >  
         <tr>  
          <td>Nome : </td> 
          <td><form:input path="nome"  /></td>
         </tr>
          <tr>  
          <td> </td>  
          <td><input type="submit" value="Salvar" /></td>  
         </tr>  
        </table>  
       </form:form> 

</body>
</html>