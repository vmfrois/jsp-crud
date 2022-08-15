<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/updateServlet" var="uri"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Atualizando cadastro da empresa</h1>
    <form action="${uri}" method="post">
    	
    	<label>Id que deseja modificar:</label><input type="text" name="id" value="${company.id }">
        <label>Nome:</label><input type="text" name="name" value="${company.name}"/>
     
        <br />
        <br />
     
        Data de abertura: <input type="text" name="date"  value="<fmt:formatDate value="${company.dateCreated}" pattern="dd/MM/yyyy"/>" />
     	
     	
     	
        <input type="submit" />
    </form>

</body>
</html>