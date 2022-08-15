<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <body>
        <c:if test= "${not empty company}">
            <h1>Empresa ${company} removida com sucesso!</h1>
        </c:if><br />
    </body>
</html>