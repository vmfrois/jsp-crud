<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List,manager.entities.Company" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP LIST</title>
</head>
<body>
	
	<c:if test= "${not empty company }">
         <h3>Empresa ${ company } cadastrada com sucesso!</h3>
    </c:if><br />
    
	<h1>Entrei na lista de empresas</h1>
	<ul>
        <c:forEach items="${companys}" var="company">
            <li>
            ${company.name} - <fmt:formatDate value="${company.dateCreated}" pattern="dd/MM/yyyy"/> 
            <a href="/manager/getCompanyServlet?id=${company.id}">Update</a>
            <a href="/manager/RemoveServlet?id=${company.id}">Remove</a>
            </li>
        </c:forEach>
    </ul>
	


</body>
</html>