<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List,manager.entities.Company" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	
	<h1>Entrei na lista de empresas</h1>
	<ul>
        <c:forEach items="${company}" var="company">
            <li>${company.name}</li>
        </c:forEach>
    </ul>
	


</body>
</html>